# FastCountryPicker
An android library for listing all the countries and user can select the country name, code, dial code and flag.
auto select country code 

![stack Overflow](https://scontent-amt2-1.xx.fbcdn.net/v/t1.15752-9/216208666_806292543580380_5867943563406577971_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=ae9488&_nc_eui2=AeGxQMgEe5doHMwuxOc7_PNSFAJ_K-DuMdgUAn8r4O4x2Nv1Zv9HNqDqh4xCz-PIzkmrVsZfBMnFsGBKzl7IpP5h&_nc_ohc=u8yQBGx4ZDMAX8yWBwF&tn=-Vt39XWB7CFMNonH&_nc_ht=scontent-amt2-1.xx&oh=737c00381b213f0e5bb6d9d84eee4b09&oe=60F21184)

![stack Overflow](https://scontent-ams4-1.xx.fbcdn.net/v/t1.15752-9/214705831_1400289497014133_703159684205771225_n.jpg?_nc_cat=110&ccb=1-3&_nc_sid=ae9488&_nc_eui2=AeE1Ly9HqH1kJSJAHzBNtidJXDFgWHET1ihcMWBYcRPWKArVxuDAiWmE0pTSm23smLdwR_kK-0jgHMMyIn5Wy0Wu&_nc_ohc=IK2_6eMukmwAX9xco5r&_nc_ht=scontent-ams4-1.xx&oh=8d516deb45e70e51125cfc5b5c1aa079&oe=60F14212)

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
