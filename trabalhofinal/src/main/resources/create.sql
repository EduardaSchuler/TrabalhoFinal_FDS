CREATE TABLE Usuario (
    usuario         VARCHAR(255) PRIMARY KEY
,   senha           VARCHAR(255)
);

CREATE TABLE Aplicativo (
    codigo          BIGINT        PRIMARY KEY
,   nome            VARCHAR(255)                
,   custoMensal     DECIMAL(10, 2)
);

CREATE TABLE Cliente (
    codigo         BIGINT          PRIMARY KEY
,   nome           VARCHAR(255) 
,   email          VARCHAR(255) 
);


CREATE TABLE Assinatura (
    codigo             BIGINT      PRIMARY KEY
,   codigoAplicativo   BIGINT 
,   codigoCliente      BIGINT
,   inicioVigencia     DATE
,   fimVigencia        DATE
,   status             VARCHAR(10)
);

CREATE TABLE Pagamento (
    codigo              BIGINT     PRIMARY KEY
,   codigoAssinatura    BIGINT
,   valorPago           DECIMAL(10, 2) 
,   dataPagamento       DATE
,   promocao            VARCHAR(255)
);
