package nitish.employeeAddress.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nitish.employeeAddress.model.Address;
import nitish.employeeAddress.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;
   @PostMapping("address")
    public String postAddress(Address address) {
        iAddressRepo.save(address);
        return "Address saved";
    }

    public List<Address> getAddresses() {
       return iAddressRepo.findAll();
    }

    public Address getAddressById(Long id) {
       return iAddressRepo.findById(id).orElse(null);
    }

    public String deleteAddressById(Long id) {
       Address addres=iAddressRepo.findById(id).orElse(null);
       if(addres!=null){
       iAddressRepo.deleteById(id);
       return "address deleted";
       }
       return "invalid id";
    }

    public String deleteAddressByid(Long id,Address address) {
        Address addres=iAddressRepo.findById(id).orElse(null);
        if(addres!=null){
            addres.setCity(address.getCity());
            addres.setState(address.getState());
            iAddressRepo.save(addres);
            return "address updated";
        }
        return "invalid id";

    }
}
