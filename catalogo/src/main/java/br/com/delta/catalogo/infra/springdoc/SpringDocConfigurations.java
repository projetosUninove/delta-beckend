package br.com.delta.catalogo.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("Documentação Externa da API no GitHub")
                .url("https://github.com/projetosUninove/delta-beckend");

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Delta API")
                        .description("O Projeto Extensionista para a empresa Delta Descartáveis e Produtos de" +
                                " Limpeza é uma iniciativa universitária que visa o desenvolvimento de um catálogo" +
                                " digital para impulsionar a presença digital da empresa. Este projeto busca oferecer" +
                                " uma solução tecnológica para facilitar o acesso dos clientes aos produtos, melhorar a" +
                                " visibilidade no mercado e simplificar o processo de realização e recebimento de pedidos." +
                                " O escopo inclui o desenvolvimento de uma interface responsiva, cadastro de usuários," +
                                " gerenciamento de inventário e um sistema de encaminhamento de pedidos.")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("por email")
                                .email("projetos.uninove.2023@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://www.mit.edu/~amini/LICENSE.md")))
                .externalDocs(externalDocumentation);
    }
}
