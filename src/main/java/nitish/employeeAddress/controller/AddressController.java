package nitish.employeeAddress.controller;

import nitish.employeeAddress.model.Address;
import nitish.employeeAddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
       return addressService.postAddress(address);
    }
    @GetMapping("address/list")
    public List<Address> getListOfAddress(){
        return addressService.getAddresses();
    }
    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @DeleteMapping("address/id/{id}")
    public String deleteById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }
    @PutMapping("address/id/{id}")
    public String updateAddressById(@PathVariable Long id,@RequestBody Address address){
        return addressService.deleteAddressByid(id,address);
    }

}
