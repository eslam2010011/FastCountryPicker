# FastCountryPicker
An android library for listing all the countries and user can select the country name, code, dial code and flag.
auto select country code 

![stack Overflow](https://firebasestorage.googleapis.com/v0/b/myapplication-87d95.appspot.com/o/213087031_4275310019182098_1240683911978017221_n.jpg?alt=media&token=eaad1512-a38f-4210-8945-b56768f4b8b1)

![stack Overflow](https://scontent.fcai20-4.fna.fbcdn.net/v/t1.15752-9/217135340_4091486820938264_6123306934561927069_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeH7es3EIVqf2-xM6L3YLGwmwVsGiKUKeF_BWwaIpQp4XzeoirNNEGhg8TlSwbGSzLawQs0lNCZPVhHaScZn_DIu&_nc_ohc=k2PnjM0jJ1UAX9hBAYK&_nc_ht=scontent.fcai20-4.fna&oh=a9fea3cf3a00361a88a685ef9c18393b&oe=61749B39)

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
