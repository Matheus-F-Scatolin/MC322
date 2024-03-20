// Classe Jogador
public class Jogador {
    // Atributos do jogador
    private String nome;
    private String cpf;
    private String email;
    // Atributo para armazenar o caminho da foto do jogador
    private String foto;

    // Construtor do jogador
    public Jogador(String nome, String cpf, String email, String foto) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
    }

    // Getters e setters
    // Nome: nome do jogador
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Cpf: CPF do jogador
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Email: email do jogador
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Foto: caminho da foto do jogador
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    // Métodos
    // Validação de CPF

    /*
     * Essa função calcula o primeiro dígito verificador do CPF.
     * @param cpf: o CPF a ser validado
     * @return: o primeiro dígito verificador do CPF
     */
    private int calcularPrimeiroDV(String cpf) {
        // Efetuar a soma dos produtos entre os digitos do CPF e os pesos (que variam de 10 a 2)
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (Character.getNumericValue(cpf.charAt(i))) * (10 - i);
        }
        // O primeiro digito verificador é calculado como sendo 11 - (soma % 11)
        int digito1 = 11 - (soma % 11);
        // Se o resultado for maior que 9, o digito deve ser 0
        if (digito1 > 9) {
            digito1 = 0;
        }
        return digito1;
    }

    /*
     * Essa função calcula o segundo dígito verificador do CPF.
     * @param cpf: o CPF a ser validado
     * @return: o segundo dígito verificador do CPF
     */
    private int calcularSegundoDV(String cpf) {
        // Efetuar a soma dos produtos entre os digitos do CPF e os pesos (que variam de 11 a 2)
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (Character.getNumericValue(cpf.charAt(i))) * (11 - i);
        }
        // O segundo digito verificador é calculado como sendo 11 - (soma % 11)
        int digito2 = 11 - (soma % 11);
        // Se o resultado for maior que 9, o digito deve ser 0
        if (digito2 > 9) {
            digito2 = 0;
        }
        return digito2;
    }

    /* 
     * Essa função verifica se um CPF é válido ou não, passando por diversos passos
     * de validação, que incluem a verificação do tamanho do CPF e a verificação dos
     * digitos verificadores.
     * @param cpf: o CPF a ser validado
     * @return: true se o CPF é válido, false caso contrário
    */
    public boolean validarCPF() {
        String cpf = this.getCpf();
        //Removendo todos os caracteres nao numericos do CPF usando o metodo replaceAll;
        cpf = cpf.replaceAll("\\D", "");
        // Verificando se o CPF possui 11 digitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificando se o CPF possui todos os digitos iguais
        String primeiroDigito = cpf.substring(0, 1);
        for (int i = 1; i < 11; i++) {
            if (!cpf.substring(i, i + 1).equals(primeiroDigito)) {
                break;
            }
            if (i == 10) {
                return false;
            }
        }

        // Calculando o primeiro digito verificador
        int primeiroDV = calcularPrimeiroDV(cpf);
        //Se ele estiver correto, calcular o segundo digito verificador
        if (Character.getNumericValue(cpf.charAt(9)) == primeiroDV) {
            int segundoDV = calcularSegundoDV(cpf);
            //Se o segundo digito verificador estiver correto, o CPF é válido
            if (Character.getNumericValue(cpf.charAt(10)) == segundoDV) {
                return true;
            }
        }
        //Se o primeiro ou o segundo digito verificador estiverem incorretos, o CPF é inválido
        return false;
    }

    // Validação de email
    /* 
     * Essa função verifica se um email é válido ou não, passando por diversos passos
     * de validação, que incluem a verificação da presença de "@" e ".", e a verificação
     * do tamanho de cada uma das partes do email. Um exemplo de email válido é 
     * "exemplo@gmail.com".
     * @param email: o email a ser validado
     * @return: true se o email é válido, false caso contrário
     */
    public boolean validarEmail() {
        String email = this.getEmail();
        // Verificando se o email possui um "@" e um "."
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        
        // Verificando se o email possui pelo menos 3 caracteres antes do "@"
        if (email.indexOf("@") < 3) {
            return false;
        }

        // Verificando se o email possui pelo menos 3 caracteres antes do "."
        if (email.indexOf(".") - email.indexOf("@") < 3) {
            return false;
        }

        // Verificando se o email possui pelo menos 2 caracteres depois do "."
        if (email.length() - email.indexOf(".") < 3) {
            return false;
        }
        return true;
    }

    /* 
     * Essa função retorna os dados do jogador, incluindo nome, CPF, email e foto.
     * @return: os dados do jogador
     */
    public String toString() {
        return "Dados do jogador:\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nEmail: "
        + this.getEmail() + "\nFoto: " + this.getFoto();
    }
}