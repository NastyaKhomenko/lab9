package lviv.iot.lab8;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ua.lviv.iot.CarCleaningGoods.models.Brusher;
import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;
import ua.lviv.iot.CarCleaningGoods.models.Convenience;
import ua.lviv.iot.CarCleaningGoods.models.Quality;

@SpringBootApplication
@EntityScan(basePackages = { "ua.lviv.iot.CarCleaningGoods.models" })
public class Lab8Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab8Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final CarCleaningGoodsRepository repository) {
        return (args) -> {
            
            repository.save(new CarCleaningGoods("Detergent", "Carl", "Poland", 20, 90, Quality.MEDIUM));
            repository.save(new CarCleaningGoods("Oil", "GeneralMotors", "USA", 80, 60, Quality.BAD));
            repository.save(new Brusher("Detergent", "Carl", "Poland", 20, 90, Quality.MEDIUM, "green",
                    Convenience.COMFORTABLE)); 
        };
    }
    
    @Bean
    public CommandLineRunner demo2(final BrusherRepository repository) {
        return (args) -> {
            
           
            repository.save(new Brusher("Detergent", "Carl", "Poland", 20, 90, Quality.MEDIUM, "green",
                    Convenience.COMFORTABLE)); 
        };
    }
}
