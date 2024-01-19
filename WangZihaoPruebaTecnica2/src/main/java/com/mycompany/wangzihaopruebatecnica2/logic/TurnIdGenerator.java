
package com.mycompany.wangzihaopruebatecnica2.logic;

import java.util.Optional;

/**
 *
 * @author Zihao Wang
 */
public class TurnIdGenerator {
    
    Controller controller=new Controller();
    
    public TurnIdGenerator(){
        
    }
    
    /**
     * Method that generates an automatic id for shift
     * @return String newId
     */
    public String turnIdGenerator(){
        long turnMax=0;
        String strLastTurn="";
        if(!controller.findAllTurns().isEmpty()){
            System.out.println(controller.findAllTurns());
            turnMax=controller.findAllTurns().stream().count();
            Optional<Turn> lastTurn=controller.findAllTurns().stream().reduce((first, second) -> second);
            strLastTurn=lastTurn.get().getId();
        }
        String strTurnMax=Long.toString(turnMax);
        String[] abcd={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","z"};
        int indiceAbcd=0;
        String[] strTurnId;
        String newId;
        if(strTurnMax.equals("0")){
            newId="001-aa";
        }else{
            strTurnId=strLastTurn.replace("0", "").split("-");
            if(strTurnId[0].length()==1){
                int num=Integer.parseInt(strTurnId[0]);
                num=num+1;
                if(num==10){
                    newId="0"+num+"-"+strTurnId[1];
                }else{
                    newId="00"+num+"-"+strTurnId[1];
                }
            }else if(strTurnId[0].length()==2){
                int num=Integer.parseInt(strTurnId[0]);
                num=num+1;
                if(num==100){
                    newId=num+"-"+strTurnId[1];
                }else{
                    newId="0"+num+"-"+strTurnId[1];
                }
            }else{
                int num=Integer.parseInt(strTurnId[0]);
                num=num+1;
                if(num==1000){
                    indiceAbcd=indiceAbcd+1;
                    newId="000"+"-"+strTurnId[1].substring(0,1)+abcd[indiceAbcd];
                }else{
                    newId=num+"-"+strTurnId[1];
                }
            }
        }
        return newId;
    }

}
