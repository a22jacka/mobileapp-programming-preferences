#Rapport

Det första som gjordes var att skapa en till activity. I MainActivity så sattes en editText och en knapp och 
i SecondActivity så sattes en textView. För att kunna gå emellan sidorna så användes intents på MainActivity 
och MainActivity sattes som förälder till SecondActivity vilket gör att det är möjligt att gå tillbaka till
Main via en pil i toolbaren.


```
private SharedPreferences myPreferenceRef;
private SharedPreferences.Editor myPreferenceEditor;
protected void onCreate(Bundle savedInstanceState) {
    [...]
    myPreferenceRef = getSharedPreferences("key", MODE_PRIVATE);
    myPreferenceEditor = myPreferenceRef.edit();
    TextView prefTextRef= findViewById(R.id.textView);
    prefTextRef.setText(myPreferenceRef.getString("key", "No preference found."));
}
```
Kod 1: Sätter upp preferences i MainActivity



```
@Override
protected void onResume() {
    super.onResume();
    TextView sharedPrefData = findViewById(R.id.textView);
    sharedPrefData.setText(myPreferenceRef.getString("key", "Name"));
}
```
Kod 2: Läser preferences i MainActivity



```
void store() {
        EditText sharedPrefData = findViewById(R.id.editTextTextPersonName);
        myPreferenceEditor.putString("key", sharedPrefData.getText().toString());
        myPreferenceEditor.apply();
    }
```
Kod 3: Skriver till preferences i SecondActivity