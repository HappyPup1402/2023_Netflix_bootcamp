package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceLayerTest {
    ServiceLayer service;
    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    InvoiceRepository invoiceRepository;
    T_ShirtRepository t_shirtRepository;
    FeeRepository feeRepository;
    TaxRepository taxRepository;

    @BeforeEach
    public void setUp() throws Exception{
        setUpConsoleRepositoryMock();
        setUpGameRepositoryMock();
        setUpInvoiceRepositoryMock();
        setUpT_ShirtRepositoryMock();

        service = new ServiceLayer(consoleRepository,taxRepository,t_shirtRepository,invoiceRepository,feeRepository,gameRepository);
    }

    private void setUpConsoleRepositoryMock(){
        consoleRepository = mock(ConsoleRepository.class);
        Console console = new Console();
        console.setId(1);
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setModel("Ps5");
        console2.setManufacturer("sony");
        console2.setMemory_amount("825GB");
        console2.setProcessor("AMD Zen 2 CPU");
        console2.setPrice(BigDecimal.valueOf(500));
        console2.setQuantity(1);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        doReturn(console).when(consoleRepository).save(console2);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(consoleList).when(consoleRepository).findAll();
        doReturn(consoleList).when(consoleRepository).findByManufacturer("sony");

    }

    private void setUpGameRepositoryMock(){
        gameRepository = mock(GameRepository.class);
        Game game = new Game();
        game.setId(1);
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("God of war");
        game2.setEsrbRating("Pegi 18");
        game2.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game2.setPrice(new BigDecimal(60.00));
        game2.setStudio("Santa Monica Studio");
        game2.setQuantity(1);


        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameRepository).save(game2);
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(gameList).when(gameRepository).findAll();
        doReturn(gameList).when(gameRepository).findByStudio("Santa Monica Studio");
        doReturn(gameList).when(gameRepository).findByEsrbRating("Pegi 18");
        doReturn(gameList).when(gameRepository).findByTitle("God of war");


    }

    private void setUpInvoiceRepositoryMock(){
        invoiceRepository = mock(InvoiceRepository.class);
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setQuantity(1);

        Invoice invoice2 = new Invoice();
        invoice2.setName("Izaac Ramirez");
        invoice2.setState("Elmcroft Ave");
        invoice2.setCity("Norwalk");
        invoice2.setState("CA");
        invoice2.setZipcode("90650");
        invoice2.setItemType("Game");
        invoice2.setItemId(562);
        invoice2.setQuantity(1);

        List<Invoice> invoiceList =  new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice)).when(invoiceRepository).findById(1);
        doReturn(invoiceList).when(invoiceRepository).findAll();
        doReturn(invoiceList).when(invoiceRepository).findByName("Izaac Ramirez");

    }

    private void setUpT_ShirtRepositoryMock(){
        t_shirtRepository = mock(T_ShirtRepository.class);
        T_Shirt TShirt = new T_Shirt();
        TShirt.setId(1);
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        T_Shirt TShirt2 = new T_Shirt();
        TShirt2.setSize("XL");
        TShirt2.setColor("Black");
        TShirt2.setDescription("Black tshirt with naruto on it");
        TShirt2.setPrice(new BigDecimal(30.00));
        TShirt2.setQuantity(2);

        List<T_Shirt> tShirtList =  new ArrayList<>();
        tShirtList.add(TShirt);

        doReturn(TShirt).when(t_shirtRepository).save(TShirt2);
        doReturn(Optional.of(TShirt)).when(t_shirtRepository).findById(1);
        doReturn(tShirtList).when(t_shirtRepository).findAll();
        doReturn(tShirtList).when(t_shirtRepository).findByColor("Black");
        doReturn(tShirtList).when(t_shirtRepository).findBySize("XL");
    }

    //Console Api

    @Test
    public void shouldSaveConsole(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = service.saveConsole(console);

        Console console1 = service.findConsoleById(console.getId());

        assertEquals(console, console1);

    }

    @Test
    public void shouldFindConsoleById(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console =service.saveConsole(console);

        Console console1 = service.findConsoleById(console.getId());

        assertNotNull(console1);
    }

    @Test
    public void shouldFindAllConsoles(){
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = service.saveConsole(console);

        List<Console> allConsoles = service.findAllConsoles();
        assertEquals(allConsoles.size(), 1);
    }

    @Test
    public void shouldFindByManufacturer(){
        List<Console> consoleList = new ArrayList<>();
        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        console = service.saveConsole(console);

        consoleList.add(console);

        List<Console> tempConsoleList = service.findByManufacturer(console.getManufacturer());
        assertEquals(tempConsoleList, consoleList);

    }

    //Game Api

    @Test
    public void shouldSaveGame(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = service.saveGame(game);

        Game tempGame = service.findGameById(game.getId());
        assertEquals(tempGame, game);
    }

    @Test
    public void shouldFindGameById(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = service.saveGame(game);

        Game tempGame = service.findGameById(game.getId());
        assertNotNull(tempGame);
    }

    @Test
    public void shouldFindAllGames(){
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        game = service.saveGame(game);

        List<Game> tempGame = service.findAllGames();
        assertEquals(tempGame.size(),1);
    }

    @Test
    public void shouldFindByStudio(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);
        game = service.saveGame(game);

        gameList.add(game);

        List<Game> tempGameList = service.findByTitle(game.getTitle());
        assertEquals(tempGameList, gameList);
    }

    @Test
    public void shouldFindByEsrbRating(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);
        game = service.saveGame(game);

        gameList.add(game);

        List<Game> tempGameList = service.findByTitle(game.getTitle());
        assertEquals(tempGameList, gameList);
    }

    @Test
    public void shouldFindByTitle(){
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);
        game = service.saveGame(game);

        gameList.add(game);

        List<Game> tempGameList = service.findByTitle(game.getTitle());
        assertEquals(tempGameList, gameList);

    }

    //T_Shirt Api

    @Test
    public void shouldSaveTShirt(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = service.saveTShirt(TShirt);
        T_Shirt tempTShirt = service.findTShirtById(TShirt.getId());
        assertEquals(tempTShirt, TShirt);
    }

    @Test
    public void shouldFindTShitById(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = service.saveTShirt(TShirt);
        T_Shirt tempTShirt = service.findTShirtById(TShirt.getId());
        assertNotNull(tempTShirt);
    }

    @Test
    public void shouldFindAllTShirts(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        TShirt = service.saveTShirt(TShirt);
        List<T_Shirt> tShirtList = service.findAllTShirts();
        assertEquals(tShirtList.size(), 1);
    }

    @Test
    public void shouldFindByColor(){
        List<T_Shirt> shirtList = new ArrayList<>();

        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);
        TShirt = service.saveTShirt(TShirt);

        shirtList.add(TShirt);

        List<T_Shirt> tShirtList = service.findByColor(TShirt.getColor());
        assertEquals(tShirtList, shirtList);

    }

    @Test
    public void shouldFindBySize(){
        List<T_Shirt> shirtList = new ArrayList<>();

        T_Shirt TShirt = new T_Shirt();
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);
        TShirt = service.saveTShirt(TShirt);

        shirtList.add(TShirt);

        List<T_Shirt> tShirtList = service.findBySize(TShirt.getSize());
        assertEquals(tShirtList, shirtList);
    }

    //Invoice Api

    @Test
    public void shouldSaveInvoice(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setQuantity(1);

        invoice = service.saveInvoice(invoice);

        Invoice tempInvoice = service.findInvoiceById(invoice.getId());
        assertEquals(tempInvoice,invoice);
    }

    @Test
    public void shouldFindInvoiceById(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setQuantity(1);

        invoice = service.saveInvoice(invoice);

        Invoice tempInvoice = service.findInvoiceById(invoice.getId());
        assertNotNull(tempInvoice);
    }

    @Test
    public void shouldFindAllInvoices(){
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setQuantity(1);

        invoice = service.saveInvoice(invoice);

        List<Invoice> invoiceList = service.findAllInvoices();
        assertEquals(invoiceList.size(), 1);
    }

    @Test
    public void shouldFindByName(){
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItemType("Game");
        invoice.setItemId(562);
        invoice.setQuantity(1);
        invoice = service.saveInvoice(invoice);

        invoiceList.add(invoice);

        List<Invoice> tempInvoiceList = service.findByName(invoice.getName());
        assertEquals(tempInvoiceList, invoiceList);

    }

}
