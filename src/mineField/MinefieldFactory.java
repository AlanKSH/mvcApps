package mineField;
import mvc.*;

public class MinefieldFactory implements AppFactory{
    public Model makeModel(){
        return new Minefield();
    }
    public View makeView(Model m){
        return new MinefieldView(m);
    }
    public String getTitle(){
        return "Mine Field";
    }
    public String[] getHelp(){
        //finish
        return new String[]{"Click a button to move Rock.", "The number on each tile represents the number of mines surrounding it."};
    }
    public String about(){
        return "Mine Field by Kevin Chu, Alan Kashiwagi, Jeremy Trieu";
    }
    public String[] getEditCommands(){
        return new String[]{"N", "S", "W", "E", "NE","NW", "SE", "SW"};
    }
    public Command makeEditCommand(Model model, String type) {
        Command cmmd = null;
        if(type.equals("N")){
            //finish these commands
        }else if(type.equals("S")){

        }else if(type.equals("W")){

        }else if(type.equals("E")){

        }else if(type.equals("NE")){

        }else if(type.equals("NW")){

        }else if(type.equals("SE")){

        }else if(type.equals("SW")){

        }
        return cmmd;
    }
}
