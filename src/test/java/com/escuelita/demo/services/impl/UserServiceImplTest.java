package com.escuelita.demo.services.impl;

import com.escuelita.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Test
    public void givenOlderAge_whenCheckingAge_thenAllOk() {
        String mensaje = service.checarMayoriaEdad(18);
        assertEquals("Eres mayor de edad", mensaje);
    }

    @Test
    public void givenYoungAge_whenCheckingAge_thenAllOk() {
        String mensaje = service.checarMayoriaEdad(12);
        assertEquals("Eres menor de edad", mensaje);
    }

    @Test
    public void givenWrongNumber_whenCheckingAge_thenThrowException() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.checarMayoriaEdad(-1));
        assertEquals("Tas mal", runtimeException.getLocalizedMessage());
    }

    @Test
    public void givenToMuchAge_whenChecking_thenThrowException() {

        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.checarMayoriaEdad(101));
        assertEquals("No se puede mayor a 100", runtimeException.getLocalizedMessage());
    }
}