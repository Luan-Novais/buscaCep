package br.com.buscacep.main;

import br.com.buscacep.modulos.ConnectHttpApi;
import br.com.buscacep.modulos.Endereco;
import br.com.buscacep.modulos.EnderecoMapApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o Cep que deseja pesquisar: ");
        String cep = leitura.nextLine();
        ConnectHttpApi conexao = new ConnectHttpApi(cep);

        var res = conexao.chamaApi();
        EnderecoMapApi enderecoApi = gson.fromJson(res,EnderecoMapApi.class);
        Endereco endereco = new Endereco(enderecoApi);


    }
}
