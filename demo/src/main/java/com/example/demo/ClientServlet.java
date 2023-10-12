package com.example.demo;

import backend.helper.DatabaseConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import backend.dto.Client;
import backend.implementations.ClientImplementation;
import backend.services.ClientService;
import jakarta.ejb.Local;
import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

//@WebServlet(name = "ClientServlet", urlPatterns = {"backend/client-servlet"})

//@WebServlet(name = "ClientServlet", value = "/client-servlet")
@WebServlet(name = "ClientServlet", urlPatterns = {"/client-servlet"})

public class ClientServlet extends HttpServlet {

    ClientImplementation clientImplementation = new ClientImplementation();
    ClientService clientService = new ClientService(clientImplementation);


    @Override


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<Client> clientList = clientService.getAllClients();
                request.setAttribute("clientList", clientList);
        request.getRequestDispatcher("/frontend/views/clientList.jsp").forward(request, response);

    }


    /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        String name = request.getParameter("name");
        String prenoun = request.getParameter("prenoun");
        LocalDate birthdatestr = LocalDate.parse(request.getParameter("birthdate"));
        System.out.println("birthdatestr: " + birthdatestr);
       // LocalDate parsedBirthdate = null;
        String phone = request.getParameter("phone");
        String adresse = request.getParameter("adresse");

    //    Logger logger = Logger.getLogger(ClientServlet.class.getName());

                Client client = new Client(name, prenoun, birthdatestr, phone, adresse);
                System.out.println(client);
                Optional<Client> addedClient = clientService.addclient(client);

        if (addedClient.isPresent()) {
            request.setAttribute("successMessage", "Client added successfully");
            request.getRequestDispatcher("/frontend/views/clientList.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "failed to add Client");
            request.getRequestDispatcher("/frontend/views/formAddClient.jsp").forward(request, response);
        }
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientIdParam = request.getParameter("clientId");

        if (clientIdParam != null) {
            // Edit an existing client based on the provided clientId
            int clientId = Integer.parseInt(clientIdParam);
            // Retrieve the client by clientId and perform the edit operation
            Optional<Client> existingClientOptional = clientService.getClientById(clientId);

            if (existingClientOptional.isPresent()) {
                Client existingClient = existingClientOptional.get();
             //   request.setAttribute("existingClient", existingClient);

                request.setAttribute("existingClient", existingClient);
                final Logger logger = Logger.getLogger(ClientServlet.class.getName());
          //      System.out.println("loger Client: " + logger); // Add this line for debugging


                // Forward the request to the edit form page
                request.getRequestDispatcher("/frontend/views/formEditClient.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Client not found for editing");
                // Redirect to the client list or edit form page
                request.getRequestDispatcher("/frontend/views/clientList.jsp").forward(request, response);
            }
        } else {
            // Add a new client
            String name = request.getParameter("name");
            String prenoun = request.getParameter("prenoun");
            LocalDate birthdatestr = LocalDate.parse(request.getParameter("birthdate"));
            String phone = request.getParameter("phone");
            String adresse = request.getParameter("adresse");

            Client client = new Client(name, prenoun, birthdatestr, phone, adresse);
            Optional<Client> addedClient = clientService.addclient(client);

            if (addedClient.isPresent()) {
                request.setAttribute("successMessage", "Client added successfully");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "failed to add Client");
                request.getRequestDispatcher("/frontend/views/formAddClient.jsp").forward(request, response);
            }

            // Redirect to the client list or add form page
            request.getRequestDispatcher("/frontend/views/clientList.jsp").forward(request, response);
        }
    }




    public void destroy(){

    }
}
