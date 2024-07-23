package br.com.buscacep.modulos;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento="";
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(EnderecoMapApi enderecoApi) {
        this.cep = enderecoApi.cep();
        this.logradouro = enderecoApi.logradouro();
        this.complemento = enderecoApi.complemento();
        this.bairro = enderecoApi.bairro();
        this.cidade = enderecoApi.localidade();
        this.uf = enderecoApi.uf();

    }

    public String getCep(){
        return cep;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public String getComplemento(){
        return complemento;
    }

    public String getBairro(){
        return bairro;
    }

    public String getCidade(){
        return cidade;
    }

    public String getUf(){
        return uf;
    }

    @Override
    public String toString() {
        return "Cep: " + cep + " Logradouro: " + logradouro +
                " Complemento: " + complemento + " Bairro: " + bairro + " Cidade: " + cidade + " UF: " + uf;
    }
}
