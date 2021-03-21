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
        return new String[]{"Click a button to move Sgt. Rock, but avoid moving onto mines.",
                "The blue tile shows Rock's current location, and the number on each tile represents the number of mines surrounding it."
        , "Reach the bottom right tile to win."};
    }
    public String about(){
        return "Mine Field by Kevin Chu, Alan Kashiwagi, Jeremy Trieu";
    }
    public String[] getEditCommands(){
        return new String[]{"N", "S", "W", "E", "NE","NW", "SE", "SW"};
    }
    public Command makeEditCommand(Model model, String type) {

        if(type.equals("N")){
            return new MinefieldCommand(model,Heading.NORTH);
        }else if(type.equals("S")){
            return new MinefieldCommand(model,Heading.SOUTH);
        }else if(type.equals("W")){
            return new MinefieldCommand(model,Heading.WEST);
        }else if(type.equals("E")){
            return new MinefieldCommand(model,Heading.EAST);
        }else if(type.equals("NE")){
            return new MinefieldCommand(model,Heading.NORTH_EAST);
        }else if(type.equals("NW")){
            return new MinefieldCommand(model,Heading.NORTH_WEST);
        }else if(type.equals("SE")){
            return new MinefieldCommand(model,Heading.SOUTH_EAST);
        }else if(type.equals("SW")){
            return new MinefieldCommand(model,Heading.SOUTH_WEST);
        }
        return null;
    }
}
