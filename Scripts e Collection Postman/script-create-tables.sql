CREATE TABLE IF NOT EXISTS `mydb`.`Entrega` (
  `idEntrega` BIGINT NOT NULL,
  `idVenda` BIGINT NULL,
  `enderecoLoja` VARCHAR(60) NULL,
  `enderecoDestinatario` VARCHAR(60) NULL,
  `codigoRastreio` BIGINT NULL,
  `status` VARCHAR(40) NULL,
  PRIMARY KEY (`idEntrega`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`Loja` (
  `idLoja` BIGINT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(60) NULL,
  `fone` VARCHAR(20) NULL,
  PRIMARY KEY (`idLoja`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` BIGINT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NULL,
  `nome` VARCHAR(60) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`Venda` (
  `idVenda` BIGINT NOT NULL AUTO_INCREMENT,
  `enderecoEntrega` VARCHAR(60) NULL,
  PRIMARY KEY (`idVenda`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`VendaItem` (
  `idVendaItem` BIGINT NOT NULL AUTO_INCREMENT,
  `numItem` INT NOT NULL,
  `idProduto` INT NULL,
  `qtde` INT NULL,
  `subtotal` DOUBLE NULL,
  `idVenda` BIGINT NULL,
  PRIMARY KEY (`idVendaItem`))
ENGINE = InnoDB;