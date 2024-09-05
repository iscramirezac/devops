terraform {
    required_providers {
        docker = {
            source = "kreuzwerker/docker"
            version = "~> 3.0.1"
        }
    }
}

provider "docker" {}

resource "docker_image" "nginx" {
    name = "nginx:latest"
    keep_locally = false
}

resource "docker_container" "nginx_1" {
    image = docker_image.nginx.image_id
    name  = "nginx_1"
    ports {
        internal = 80
        external = 8000
    }
}

resource "docker_container" "nginx_2" {
    image = docker_image.nginx.image_id
    name  = "nginx_2"
    ports {
        internal = 80
        external = 8001
    }
}