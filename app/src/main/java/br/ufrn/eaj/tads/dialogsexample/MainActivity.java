package br.ufrn.eaj.tads.dialogsexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean mySelectedItemsReference[] = {false,false,false};
    String[] mySelectedItemsData = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickButtonAlertDialog(View v){

        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog);


        /*
        * Teste os seguintes temas de AlertDialog
         */

        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light);
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Dialog);
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Presentation);
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Presentation);
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material);
        AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_NoActionBar_MinWidth);

        alerta.setIcon(R.mipmap.ic_launcher);

        //método para impedir que o usuário cancele a dialogAlert
        alerta.setCancelable(false);
        alerta.setTitle("Título");
        alerta.setMessage("Você sabe programar para Android?");

        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Parabéns", Toast.LENGTH_LONG).show();
            }
        });
        alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, ":( Estude mais", Toast.LENGTH_LONG).show();
            }
        });

        alerta.setNeutralButton("Depois", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Vê se não esquece...", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog criaalerta = alerta.create();
        criaalerta.show();
    }

    public void onClickButtonListDialog(View v){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog);
        alerta.setIcon(R.mipmap.ic_launcher);
        alerta.setTitle("Escolha a cor:");
        alerta.setItems(R.array.cores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                ConstraintLayout fundo = (ConstraintLayout) findViewById(R.id.fundo);

                switch (i){
                    case 0:{
                        fundo.setBackgroundResource(android.R.color.holo_red_dark);
                        break;
                    }
                    case 1:{
                        fundo.setBackgroundResource(android.R.color.holo_orange_dark);
                        break;
                    }
                    case 2:{
                        fundo.setBackgroundResource(android.R.color.holo_blue_light);
                        break;
                    }
                }

            }
        });

        AlertDialog criaalerta = alerta.create();
        criaalerta.show();
    }

    public void onClickButtonMultiDialog(View v){


        AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog);
        alerta.setIcon(R.mipmap.ic_launcher);
        alerta.setTitle("Escolha a cor:");
        alerta.setMultiChoiceItems(R.array.frutas,mySelectedItemsReference, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int itemid, boolean isChecked) {
                if (isChecked) {
                    // If the user checked the item, add it to the selected items
                    mySelectedItemsReference[itemid] = true;
                    mySelectedItemsData[itemid] = ""+itemid;
                } else {
                    // Else, if the item is already in the array, remove it
                    mySelectedItemsReference[itemid] = false;
                    mySelectedItemsData[itemid] = null;
                }
            }
        });

        alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, Arrays.toString(mySelectedItemsData), Toast.LENGTH_LONG).show();
            }
        });
        alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_LONG).show();
            }
        });


        AlertDialog criaalerta = alerta.create();
        criaalerta.show();
    }

    public void onClickButtonCustomDialog(View v){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog);

        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        alerta.setView(inflater.inflate(R.layout.dialog_login, null));

        alerta.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_LONG).show();
            }
        });
        alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_LONG).show();
            }
        });


        AlertDialog criaalerta = alerta.create();
        criaalerta.show();

    }


    public void onClickButtonSnack1(View v){
        Snackbar snack = Snackbar.make((View)v.getParent(), R.string.sucesso, Snackbar.LENGTH_LONG);
        snack.show();
    }


    public void onClickButtonSnack2(View v){
        Snackbar snack = Snackbar.make((View)v.getParent(), R.string.sucesso, Snackbar.LENGTH_LONG)
                .setAction(R.string.cancelar, snacklistener);
        snack.show();
    }

    private View.OnClickListener snacklistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Cancelou", Toast.LENGTH_SHORT).show();
        }
    };

    /*
    public void click7(View v){
        Snackbar snack = Snackbar.make((View)v.getParent(), R.string.sucesso, Snackbar.LENGTH_LONG)
                .setAction(R.string.cancelar, new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Cancelou", Toast.LENGTH_SHORT).show();
                    }
                });
        snack.show();
    }
    */
}
