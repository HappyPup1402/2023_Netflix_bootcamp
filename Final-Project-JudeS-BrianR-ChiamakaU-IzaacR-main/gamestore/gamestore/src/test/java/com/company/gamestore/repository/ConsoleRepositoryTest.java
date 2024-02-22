package com.company.gamestore.repository;

import com.company.gamestore.model.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConsoleRepositoryTest {
    @Autowired
    ConsoleRepository consoleRepository;

    @BeforeEach
    void setUp(){
        consoleRepository.deleteAll();
    }

    @Test
    public void createConsoleTest(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        Optional<Console> newConsole = consoleRepository.findById(console.getId());
        assertEquals(newConsole.get(), console);
    }

    @Test
    public void getConsoleByIdTest(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        Optional<Console> retrievedConsole = consoleRepository.findById(console.getId());
        assertEquals(retrievedConsole.get(), console);
    }

    @Test
    public void getAllConsolesTest(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        Console console2 = new Console();
        console2.setModel("Xbox one");
        console2.setManufacturer("Microsoft");
        console2.setMemory_amount("256GB");
        console2.setProcessor("i7");
        console2.setPrice(BigDecimal.valueOf(400));
        console2.setQuantity(1);

        console2 = consoleRepository.save(console2);

        List<Console> allConsoles = consoleRepository.findAll();
        assertEquals(allConsoles.size(), 2);
    }

    @Test
    public void updateConsoleTest(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        console.setPrice(new BigDecimal("400.00"));

        consoleRepository.save(console);

        Optional<Console> updatedConsole = consoleRepository.findById(console.getId());
        assertEquals(updatedConsole.get(), console);
    }

    @Test
    public void deleteConsoleTest(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        consoleRepository.delete(console);

        Console deletedConsole = consoleRepository.findById(console.getId()).orElse(null);
        assertNull(deletedConsole);
    }

    @Test
    public void findByManufacturerTest() {
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = consoleRepository.save(console);

        List<Console> retrievedConsole = consoleRepository.findByManufacturer("sony");
        assertEquals(retrievedConsole.size(), 1);
    }
}