package lviv.iot.lab8;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.CarCleaningGoods.models.Brusher;
import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;

@RestController
@RequestMapping(value = "/Brusher")
public class BrusherControler {

   
      @Autowired
      BrusherRepository brushersRepository;
     
      @GetMapping("/Brusher")
      public List getAlldBrusher() {
        return  (List) brushersRepository.findAll();
      }

      @GetMapping("/Brusher/{id}")
      public Brusher getBrusher(@PathVariable Integer id) {
        return brushersRepository.findById(id).get();
      }

      
      @PostMapping("/Brusher")
        public Brusher createBrusher(@RequestBody Brusher brusher) {
          Brusher savedBrusher = brushersRepository.save(brusher);
        return savedBrusher;
      }
      
      @PutMapping("/Brusher/{id}")
       public  Brusher updateBrusher(
          @RequestBody Brusher changedBrusher, @PathVariable Integer id) {
          brushersRepository.save(changedBrusher);
        return changedBrusher;
      }
      
      @PutMapping("/pharmacy/{id}")
      Optional<CarCleaningGoods> replaceGood(@RequestBody CarCleaningGoods newGood, @PathVariable Integer id) {
          return brushersRepository.findById(id)
                  .map(good -> {
                      good.setName(newGood.getName());
                      good.setProducer(newGood.getProducer());
                      good.setCountry(newGood.getCountry());
                      good.setSalesPerDay(newGood.getSalesPerDay());
                      good.setPrice(newGood.getPrice());
                      good.setQuality(newGood.getQuality());
                      return brushersRepository.save(good);
                  });
      }
      
      @DeleteMapping("/Brusher/{id}")
      public String deleteBrusher(@PathVariable Integer id) {
          brushersRepository.deleteById(id);
        return String.format("Brusher id #%d successfully deleted", id);
      }
      
    }

    

