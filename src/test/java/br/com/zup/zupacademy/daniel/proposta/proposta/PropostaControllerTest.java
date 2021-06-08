package br.com.zup.zupacademy.daniel.proposta.proposta;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@SpringBootTest
class PropostaControllerTest {

    @Autowired
    MockMvc mockMvc;

    JsonMapper mapper = new JsonMapper();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deveFalharAoTentarCadastrarPropostaComDocumentoInvalido() throws Exception {
        ObjectNode propostaNode = mapper.createObjectNode();
        propostaNode.put("documento","583.568.980-01");
        propostaNode.put("email","email@email.com");
        propostaNode.put("nome","john");
        propostaNode.put("endereco","rua dos johns, 95");
        propostaNode.put("salario","2300");

        String propostaJson = propostaNode.toPrettyString();

        URI uri = URI.create("/proposta");

        mockMvc.perform(
                MockMvcRequestBuilders
                .post(uri)
                .content(propostaJson)
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void deveCadastrarPropostaComSucesso() throws Exception {
        ObjectNode propostaNode = mapper.createObjectNode();
        propostaNode.put("documento","583.568.980-21");
        propostaNode.put("email","email@email.com");
        propostaNode.put("nome","john");
        propostaNode.put("endereco","rua dos johns, 95");
        propostaNode.put("salario","2300");

        String propostaJson = propostaNode.toPrettyString();

        URI uri = URI.create("/proposta");

        mockMvc.perform(
                MockMvcRequestBuilders
                .post(uri)
                .content(propostaJson)
                .contentType("application/json")
        )
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }
}