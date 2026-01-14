package es.uah.cineapp.command;

import org.springframework.stereotype.Component;

@Component
public class CommandInvoker {


    private Command command;

    public void setCommand(Command command) {
        this.command = command;  // Establece el comando a ejecutar
    }

    public void executeCommand() {
        command.execute();  // Ejecuta el comando
    }
}
