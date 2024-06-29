-- inserts tabela de aplicativos

INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (1500, 'Netflix', 39.90); 
INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (1600, 'Amazon Prime', 14.90); 
INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (1700, 'Disney Plus', 29.90); 
INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (1800, 'HBO Max', 49.90); 

-- inserts tabelas de clientes

INSERT INTO Cliente (codigo, nome, email) VALUES (2401, 'Joana Palmeiras', 'joanapal@gmail.com'); 
INSERT INTO Cliente (codigo, nome, email) VALUES (2402, 'Vitor Ulisses Machado', 'vitorulisses@outlook.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (2403, 'Daniela Borges', 'danieborges@hotmail.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (2404, 'Roberto Nascimento Ferreira', 'robertonasc@yahoo.com');

-- inserts tabela de Assinaturas 

INSERT INTO Assinatura (codigo, codigoCliente, codigoAplicativo, inicioVigencia, fimVigencia, status) VALUES (2222, 1500, 2401, '2024-06-22', '2024-07-22', null);
INSERT INTO Assinatura (codigo, codigoCliente, codigoAplicativo, inicioVigencia, fimVigencia, status) VALUES (3333, 1600, 2402, '2024-02-22', '2024-03-22', null);
INSERT INTO Assinatura (codigo, codigoCliente, codigoAplicativo, inicioVigencia, fimVigencia, status) VALUES (4444, 1700, 2403, '2024-06-22', '2024-07-22', null);
INSERT INTO Assinatura (codigo, codigoCliente, codigoAplicativo, inicioVigencia, fimVigencia, status) VALUES (5555, 1800, 2404, '2024-06-22', '2024-07-22', null);


-- inserts tabela de Pagamentos

INSERT INTO Pagamento (codigo, codigoAssinatura, valorPago, dataPagamento, promocao) VALUES (001, 2222, 39.90, '2024-06-22', '10% de desconto');
INSERT INTO Pagamento (codigo, codigoAssinatura, valorPago, dataPagamento, promocao) VALUES (002, 3333, 14.90, '2024-02-22', null);
INSERT INTO Pagamento (codigo, codigoAssinatura, valorPago, dataPagamento, promocao) VALUES (003, 4444, 29.90, '2024-06-22', '10% de desconto');
INSERT INTO Pagamento (codigo, codigoAssinatura, valorPago, dataPagamento, promocao) VALUES (004, 5555, 49.90, '2024-06-22', null);