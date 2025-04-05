package org;


import org.dao.*;
import org.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App
{
    CustomerDao customerDao = new CustomerDao();
    StoreDao storeDao = new StoreDao();
    CityDao cityDao = new CityDao();
    RentalDao rentalDao = new RentalDao();
    InventoryDao inventoryDao = new InventoryDao();
    FilmDao filmDao = new FilmDao();
    PaymentDao paymentDao = new PaymentDao();
    LanguageDao languageDao = new LanguageDao();
    ActorDao actorDao = new ActorDao();
    CategoryDao categoryDao = new CategoryDao();
    public static void main( String[] args ) // Транзакционность заключена в DAO. Так же установлены cascadeType.ALL
    {
        App app = new App();
//        app.createCustomer();
//        app.returnFilm();
//        app.customerGetFilm();

        app.createNewFilm();
    }

    public void createNewFilm() {
        Film film = new Film();
        film.setTitle("фильм фильмов");
        film.setDescription("описание");
        film.setYear(Year.now());

        Language language = languageDao.getLanguageById((byte) 1);

        film.setLanguage(language);
        film.setRentalDuration((byte) 0);
        film.setRentalRate(BigDecimal.ONE);
        film.setLength((short) 120);
        film.setReplacementCost(BigDecimal.TEN);
        film.setRating(Rating.PG);
        film.setSpecialFeatures("Trailers");

        Set<Actor> actorSet = actorDao.getFirstTenActors();

        film.setActors(actorSet);

        Set<Category> fiveCategories = categoryDao.getFiveCategories();

        film.setCategories(fiveCategories);

        Inventory inventory = new Inventory();
        inventory.setFilm(film);
        inventory.setStore(storeDao.getStoreById((byte) 1));

        inventoryDao.save(inventory);


    }



    public void customerGetFilm() {
        Customer customer = customerDao.getCustomerById((short) 600);
        Integer inventoryId = inventoryDao.getAvailableFilm();
        Inventory inventoryFilm = inventoryDao.getInventoryById(inventoryId);
        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setRentalDate(LocalDateTime.now());
        rental.setInventory(inventoryFilm);
        Staff staff = inventoryFilm.getStore().getStaff();
        rental.setStaff(staff);

        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setRental(rental);
        payment.setAmount(BigDecimal.TEN);

        paymentDao.save(payment);



    }


    public void returnFilm() {
        Rental rental = rentalDao.getRentalById(15191);// 15191
        rental.setReturnDate(LocalDateTime.now());
        rentalDao.update(rental);
    }


    public Customer createCustomer() {
        Customer customer = new Customer();
        customer.setStore(storeDao.getStoreById((byte) 1));
        customer.setFirstName("sanya");
        customer.setLastName("susanya");
        customer.setEmail("kdksd@gmail.com");

        Address customerAddress = new Address();
        customerAddress.setAddress("lukla streer");
        customerAddress.setCity(cityDao.getCityById((short) 5));
        customerAddress.setDistrict("CA");
        customerAddress.setPhone("7-777-928-292");

        customer.setAddress(customerAddress);
        customer.setActive(true);

        Customer save = customerDao.save(customer);

        return save;
    }
}
