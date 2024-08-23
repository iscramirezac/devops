pipeline {
    environment {
        MY_VAR = 'Valor de la variable'
        SECRET_VALUE = credentials('my_credential')
    }
}

steps {
    echo "Using secret key: ${env.SECRET_VALUE}"
    sh "echo $ MY_VAR"
}