terraform {
  backend "s3" {
    bucket = "nombre-de-tu-bucket"
    key    = "ruta/al/archivo/estado/terraform.tfstate"
    region = "us-west-2"
  }
}