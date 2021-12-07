# FastCountryPicker
An android library for listing all the countries and user can select the country name, code, dial code and flag.
auto select country code 

![stack Overflow](https://firebasestorage.googleapis.com/v0/b/myapplication-87d95.appspot.com/o/213087031_4275310019182098_1240683911978017221_n.jpg?alt=media&token=eaad1512-a38f-4210-8945-b56768f4b8b1)


https://user-images.githubusercontent.com/21963428/145121645-829ad63f-077c-43f0-a5eb-778f7d694f96.mp4


![stack Overflow](https://firebasestorage.googleapis.com/v0/b/myapplication-87d95.appspot.com/o/Bugevil%20-%20Facebook_2.mp4?alt=media&token=4ffac044-49c9-46d8-99a7-66cdfdea3e16)

 # Step 1

Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:


 ```html
 allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
 ```
 
  # Step 2
 
  
  ```html
 dependencies {
	        implementation 'com.github.eslam2010011:FastCountryPicker:1'
	}
  
 ```
  
    # Step 3

   ```html

   <com.fastcountrycode.widget.FastCountryCodeM
        android:id="@+id/fab"
        android:gravity="center"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
         />
         
         /////////////////////
         
          <com.fastcountrycode.widget.FastCountryCodeOnlyM
         android:gravity="center"
        android:id="@+id/cancel_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        />
        
        ```
  
      # Step 4
      
         ```html

          FastCountryCodeOnlyM fastcountrycode =findViewById(R.id.fastcountrycode);
          
          fastcountrycode.getCountry_().getDialCode()
          //or
          fastcountrycode.setCountryPickerListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
                textView.setText(country.getDialCode());
            }
        });

```
