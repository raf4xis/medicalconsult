package br.com.rafaelteixeira.medicalconsult.usuario.services;

import br.com.rafaelteixeira.medicalconsult.usuario.domain.Usuario;
import br.com.rafaelteixeira.medicalconsult.usuario.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Rafael");
        //configuração do comportmento do MOCK
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);


        //A execução do método a ser testado
       var resulto =  usuarioService.cadastrarUsuario(usuario);



        //Validação do teste
        assertNotNull(usuario);
        assertEquals("Rafael", resulto.getNomeUsuario());

        verify(usuarioRepository, times(1)).save(usuario);

    }

    @Test
    void listarUsuario(){
        //configuração do comportmento do MOCK
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Rafael");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Teixeira");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        //configuração do comportmento do MOCK
        when(usuarioRepository.findAll()).thenReturn(usuarios);


        //A execução do método a ser testado
        var resultado = usuarioService.listarUsuarios();


        //Validação do teste
        assertAll(
                () -> assertNotNull(resultado),
                () ->  assertEquals(2,resultado.size()),
                () ->  assertEquals("Rafael",resultado.get(0).getNomeUsuario(), "Rafael"),
                () ->  assertEquals("Teixeira", resultado.get(1).getNomeUsuario(),"Teixeira")

        );



    }

}