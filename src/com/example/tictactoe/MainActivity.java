package com.example.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
private Boolean xturn=true;//check who's turn
private Boolean won=false; //check if there is a winner
private int counter=0; //use to determine a tie

//When a user clicks a button
    public void clickListener(View v){
    	
    	Button b = (Button) findViewById(v.getId());
    	won=false;
    	if(!b.getText().equals("X") && !b.getText().equals("O"))
    	{
    		if(xturn)
	    		b.setText("X");
	    	else
	        	b.setText("O");
    		counter++;
    		xturn=!xturn;//switch from X to O , X always start
    		checkWinner(v);//check to see if we have a winner
    		
    		//check for tie also make sure that they didnt win yet
    		if(!won)
    		{
    			if(counter==9)
    	    	{
    	    		AlertDialog.Builder alertWin=new AlertDialog.Builder(this);
    	    		alertWin.setMessage("We have a tie").setCancelable(false)
    	    		.setPositiveButton("Rematch", new DialogInterface.OnClickListener() 
    	    		{
    	    			
    	    			@Override
    	    			public void onClick(DialogInterface dialog, int which) {
    	    				MainActivity.this.recreate();
    	    				
    	    			}
    	    		});
    	    		AlertDialog alertDialog=alertWin.create();
    	    		alertDialog.show();
    	    	}
    		}
    	}
    }
    //our logic to check if there is a winner
    private void checkWinner(View v) {
    	Button[][] board = new Button[3][3]; 
    	board[0][0]= (Button) findViewById(R.id.b10);
    	board[0][1]= (Button) findViewById(R.id.b11);
    	board[0][2]= (Button) findViewById(R.id.b12);
    	board[1][0]= (Button) findViewById(R.id.b20);
    	board[1][1]= (Button) findViewById(R.id.b21);
    	board[1][2]= (Button) findViewById(R.id.b22);
    	board[2][0]= (Button) findViewById(R.id.b30);
    	board[2][1]= (Button) findViewById(R.id.b31);
    	board[2][2]= (Button) findViewById(R.id.b32);
    	
    	String center = (String) board[1][1].getText();
    	if ( center.equals("X") || center.equals("O"))
    	{
    		if(board[0][0].getText().equals(center ) && board[2][2].getText().equals(center ))//topleft
    			win(center);
    		else if(board[0][1].getText().equals(center ) && board[2][1].getText().equals(center ))//topmid
    			win(center);
    		else if(board[1][0].getText().equals(center ) && board[1][2].getText().equals(center ))//midleft
    			win(center);
    		else if(board[0][2].getText().equals(center ) && board[2][0].getText().equals(center ))//topright
    			win(center);
    	}
    	if(!won)
    	{
    		if ( board[0][0].getText()=="X"|| board[0][0].getText()=="O")
	    		{
    			if(board[0][0].getText()==(board[1][0].getText() ) && board[2][0].getText()==(board[1][0].getText() ))//leftdown
	    				win((String) board[0][0].getText());
	    		else if(board[0][0].getText()==(board[0][1].getText() ) && board[0][2].getText()==(board[0][1].getText() ))//topacross
	    				win((String) board[0][0].getText());
	    		}
    	}
    	if(!won)
	    	if ( board[2][2].getText()==("X") || board[2][2].getText()==("O") )	
	    	{	
	    		if(board[0][2].getText()==(board[1][2].getText() ) && board[2][2].getText()==(board[1][2].getText() ))//rightdown
							win((String) board[0][2].getText());
		    		else  if(board[2][0].getText()==(board[2][1].getText() ) && board[2][2].getText()==(board[2][1].getText() ))//bottomacross
							win((String) board[2][0].getText());
	    	}
	    
    	
    	
    	
    	   	
		
	}
    //shows the winning player and allow the user to have a rematch
	private void win(String winner) {
		AlertDialog.Builder alertWin=new AlertDialog.Builder(this);
		alertWin.setMessage(winner+" has won").setCancelable(false)
		.setPositiveButton("Rematch", new DialogInterface.OnClickListener() 
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.recreate();
				
			}
		});
		won=true;
		AlertDialog alertDialog=alertWin.create();
		alertDialog.show();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
