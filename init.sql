CREATE TABLE IF NOT EXISTS users (
    id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS banks (
  bank_code INT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
  id_category INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions (
  id_transaction INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  date DATE NOT NULL,
  type ENUM('ENTRADA', 'SAIDA', 'TRANSFERENCIA') NOT NULL,
  amount DECIMAL(15,2) NOT NULL,
  category_id INT NOT NULL,
  bank_code INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category(id_category),
  FOREIGN KEY (bank_code) REFERENCES banks(bank_code)
);

INSERT INTO users (name, email, password, role) VALUES ("Tiago", "tiago@email.com", "$2a$10$ccOdQijprWoRyqQZyTwN/uSFBzPPcqfnkTstnvhShuLPfLysPfVLW", 1); -- Senha Shigueo; role 0 = admin 1 = user

INSERT INTO banks (bank_code, name) VALUES ('001', 'Banco do Brasil S.A.'),
('003', 'Banco da Amazônia S.A.'),
('004', 'Banco do Nordeste do Brasil S.A.'),
('007', 'Banco Nacional de Desenvolvimento Econômico e Social BNDES'),
('010', 'Credicoamo Crédito Rural Cooperativa'),
('011', 'Credit Suisse Hedging-Griffo Corretora de Valores S.A.'),
('012', 'Banco Inbursa S.A.'),
('014', 'Natixis Brasil S.A. Banco Múltiplo'),
('015', 'UBS Brasil Corretora de Câmbio, Títulos e Valores Mobiliários S.A.'),
('016', 'Coop de Créd. Mútuo dos Despachantes de Trânsito de SC e Rio Grande do Sul'),
('017', 'BNY Mellon Banco S.A.'),
('018', 'Banco Tricury S.A.'),
('021', 'Banestes S.A. Banco do Estado do Espírito Santo'),
('024', 'Banco Bandepe S.A.'),
('025', 'Banco Alfa S.A.'),
('029', 'Banco Itaú Consignado S.A.'),
('033', 'Banco Santander (Brasil) S. A.'),
('036', 'Banco Bradesco BBI S.A.'),
('037', 'Banco do Estado do Pará S.A.'),
('040', 'Banco Cargill S.A.'),
('041', 'Banco do Estado do Rio Grande do Sul S.A.'),
('047', 'Banco do Estado de Sergipe S.A.'),
('060', 'Confidence Corretora de Câmbio S.A.'),
('062', 'Hipercard Banco Múltiplo S.A.'),
('063', 'Banco Bradescard S.A.'),
('064', 'Goldman Sachs do Brasil  Banco Múltiplo S. A.'),
('065', 'Banco AndBank (Brasil) S.A.'),
('066', 'Banco Morgan Stanley S. A.'),
('069', 'Banco Crefisa S.A.'),
('070', 'Banco de Brasília S.A.'),
('074', 'Banco J. Safra S.A.'),
('075', 'Banco ABN Amro S.A.'),
('076', 'Banco KDB do Brasil S.A.'),
('077', 'Banco Inter S.A.'),
('078', 'Haitong Banco de Investimento do Brasil S.A.'),
('079', 'Banco Original do Agronegócio S.A.'),
('080', 'BT Corretora de Câmbio Ltda.'),
('081', 'BBN Banco Brasileiro de Negocios S.A.'),
('082', 'Banco Topazio S.A.'),
('083', 'Banco da China Brasil S.A.'),
('084', 'Uniprime Norte do Paraná - Cooperativa de Crédito Ltda.'),
('085', 'Cooperativa Central de Crédito Urbano - Cecred'),
('089', 'Cooperativa de Crédito Rural da Região da Mogiana'),
('091', 'Central de Cooperativas de Economia e Crédito Mútuo do Est RS - Unicred'),
('092', 'BRK S.A. Crédito, Financiamento e Investimento'),
('093', 'Pólocred Sociedade de Crédito ao Microempreendedor e à Empresa de Pequeno Porte'),
('094', 'Banco Finaxis S.A.'),
('095', 'Banco Confidence de Câmbio S.A.'),
('096', 'Banco BMFBovespa de Serviços de Liquidação e Custódia S/A'),
('097', 'Cooperativa Central de Crédito Noroeste Brasileiro Ltda - CentralCredi'),
('098', 'Credialiança Cooperativa de Crédito Rural'),
('099', 'Uniprime Central – Central Interestadual de Cooperativas de Crédito Ltda.'),
('100', 'Planner Corretora de Valores S.A.'),
('101', 'Renascença Distribuidora de Títulos e Valores Mobiliários Ltda.'),
('102', 'XP Investimentos Corretora de Câmbio Títulos e Valores Mobiliários S.A.'),
('104', 'Caixa Econômica Federal'),
('105', 'Lecca Crédito, Financiamento e Investimento S/A'),
('107', 'Banco Bocom BBM S.A.'),
('108', 'PortoCred S.A. Crédito, Financiamento e Investimento'),
('111', 'Oliveira Trust Distribuidora de Títulos e Valores Mobiliários S.A.'),
('113', 'Magliano S.A. Corretora de Cambio e Valores Mobiliarios'),
('114', 'Central Cooperativa de Crédito no Estado do Espírito Santo - CECOOP'),
('117', 'Advanced Corretora de Câmbio Ltda.'),
('118', 'Standard Chartered Bank (Brasil) S.A. Banco de Investimento'),
('119', 'Banco Western Union do Brasil S.A.'),
('120', 'Banco Rodobens SA'),
('121', 'Banco Agibank S.A.'),
('122', 'Banco Bradesco BERJ S.A.'),
('124', 'Banco Woori Bank do Brasil S.A.'),
('125', 'Brasil Plural S.A. Banco Múltiplo'),
('126', 'BR Partners Banco de Investimento S.A.');;

INSERT INTO category(name) VALUES ("Presentes");

INSERT INTO transactions (date, type, amount, category_id, bank_code) VALUES ("2024-10-12", "ENTRADA", 250, 1, 208);
