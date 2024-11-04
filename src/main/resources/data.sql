DELETE FROM GASTO;
DELETE FROM VEICULO;


INSERT INTO VEICULO (placa, marca, modelo, ano) VALUES ('ABC1D23', 'Toyota', 'Corolla', 2022);
INSERT INTO VEICULO (placa, marca, modelo, ano) VALUES ('DEF2G34', 'Honda', 'Civic', 2021);
INSERT INTO VEICULO (placa, marca, modelo, ano) VALUES ('GHI3J45', 'Ford', 'Mustang', 2020);
INSERT INTO VEICULO (placa, marca, modelo, ano) VALUES ('JKL4M56', 'Chevrolet', 'Camaro', 2019);
INSERT INTO VEICULO (placa, marca, modelo, ano) VALUES ('MNO5P67', 'BMW', 'X5', 2018);

INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('COMBUSTIVEL', 150.75, '2024-01-05', 'ABC1D23');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('MANUTENCAO_PREVENTIVA', 300.50, '2024-02-10', 'DEF2G34');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('SEGURO', 1200.00, '2024-03-15', 'GHI3J45');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('ACESSORIO', 100.00, '2024-04-20', 'JKL4M56');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('MANUTENCAO_CORRETIVA', 450.25, '2024-05-25', 'MNO5P67');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('IMPOSTO', 500.00, '2024-06-30', 'ABC1D23');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('LIMPEZA', 75.50, '2024-07-05', 'DEF2G34');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('OUTRO', 1000.00, '2024-08-10', 'GHI3J45');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('COMBUSTIVEL', 160.00, '2024-09-15', 'JKL4M56');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('MANUTENCAO_PREVENTIVA', 320.75, '2024-10-20', 'MNO5P67');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('SEGURO', 1250.00, '2024-11-25', 'ABC1D23');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('OUTRO', 105.00, '2024-12-30', 'DEF2G34');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('MANUTENCAO_PREVENTIVA', 280.00, '2024-01-25', 'ABC1D23');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('ACESSORIO', 230.50, '2024-02-05', 'DEF2G34');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('OUTRO', 100.00, '2024-03-12', 'GHI3J45');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('LIMPEZA', 85.75, '2024-04-18', 'JKL4M56');
INSERT INTO GASTO (tipo_de_gasto, valor, data, veiculo_placa) VALUES ('IMPOSTO', 450.00, '2024-05-20', 'MNO5P67');

