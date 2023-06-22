package pages;

class Sender{
    public void createAndSend(Reciever reciver){
        String s="some data from Producer";
        reciver.recieve(s);
    }
}

class Reciever extends Sender{
    public void recieve(String data){
        System.out.println("I recieved "+data);
    }
}

public class javap1 {

	public static void main(String[] args) {
		
		Sender s=new Sender();
        Reciever r=new Reciever();
        
        s.createAndSend(r);
        
        Sender s1=new Reciever();
        s1.createAndSend(r);
        
        
        
        
        
        
        
        
		// TODO Auto-generated method stub

	}

}
