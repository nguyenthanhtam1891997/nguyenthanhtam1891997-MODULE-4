package com.example.phoneajax.controller;

import com.example.phoneajax.model.Phone;
import com.example.phoneajax.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api_phone")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;


    @PostMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Phone>> getPhoneList(){
        List<Phone> phoneList= phoneService.findAll();

        if (phoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(phoneList,HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable Long id){
        Phone phone = phoneService.findById(id);
        if (phone==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            phoneService.removeById(id);
            return new ResponseEntity<>(phone,HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping
    public ResponseEntity<Phone> update(@RequestBody Phone phone){
        Phone currentPhone = phoneService.findById(phone.getId());
        if (currentPhone==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            currentPhone.setModel(phone.getModel());
            currentPhone.setProducer(phone.getProducer());
            currentPhone.setPrice(phone.getPrice());
            phoneService.save(currentPhone);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
