provider "aws" {
  region = "us-west-2" 
  # profile = "default" 
}

resource "aws_vpc" "main" {
  cidr_block = "10.0.0.0/16"
}

resource "aws_subnet" "db_subnet" {
  vpc_id            = aws_vpc.main.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = "us-west-2a" # Cambia esto según la región configurada
}

resource "aws_security_group" "db_security_group" {
  name        = "db-security-group"
  description = "Permitir acceso a la base de datos PostgreSQL"
  vpc_id      = aws_vpc.main.id

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_db_instance" "postgres_instance" {
  identifier              = "my-postgres-db"
  allocated_storage       = 20
  engine                  = "postgres"
  engine_version          = "13.3"         
  instance_class          = "db.t3.micro"  
  name                    = "mi_base_de_datos"
  username                = "admin"
  password                = "super_seguro_password" 
  parameter_group_name    = "default.postgres13"
  skip_final_snapshot     = true
  publicly_accessible     = true
  vpc_security_group_ids  = [aws_security_group.db_security_group.id]
  subnet_group_name       = aws_subnet.db_subnet.id

  # Configuración opcional de backup y recuperación
  backup_retention_period = 7
  backup_window           = "03:00-06:00"
}