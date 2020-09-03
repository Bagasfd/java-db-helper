# java-db-helper

### Reqruitment
 ```java
    mysql-connector.jar \\import library on data structure
 ```

### Cara pemakaian

1. Koneksi Database

   Untuk koneksi database, cukup menggunakan method dibawah ini.
    ```java
    this.MySQLConnect("username", "password", "nama_database");
    ```
   Parameter : 
     1. Username database.
     2. Password database.
     3. Nama database.
     
   Contoh penggunaan : 
   ```java
   // Extends ke Class DB
   public class MyApp extends DB {
       public static void main(String[] args) {
           MyApp app = new MyApp();
           app.run();
       }
        
       public void run() {
           this.MySQLConnect("username", "password", "nama_database"); // Terhubung!!!
       }
   }
    ```
2. Ambil semua data (SELECT *)

   Untuk mengambil data, cukup dengan menggunakan method dibawah ini.
   ```java
   this.get("nama_tabel"); // SELECT * FROM nama_tabel
   ```
   
   Contoh penggunaan : 
   ```java
    // extends ke file CLass DB
    import java.sql.*;
    
    public class MyApp extends DB {
        public static void main(String[] args) {
            MyApp app = new MyApp();
            app.run();
        }
        
        public void run() {
            // Koneksi
            this.MySQLConnect("username", "password", "nama_database");
            
            // Query
            ResultSet result = this.get("nama_tabel"); // SELECT * FROM nama_tabel
            
            while(result.next()) {
                System.out.println(result.getInt("id")); // 1
                System.out.println(result.getString("name")); // Sasha Zotova
            }
        }
    }
    ```
 3. Ambil data spesifik (SELECT * FROM ... WHERE)
     
    Untuk mengambil data spesifik cukup dengan code dibawah ini.
    
    ```java
    // Gunakan Map untuk where-nya!!!
    Map where = new HashMap();
    where.put("nama", "Ihsan Aryandi");
    
    this.get_where("nama_tabel", where); // SELECT * FROM nama_tabel WHERE nama='Ihsan Aryandi'
    ```
    
 4. Tambah data (INSERT INTO ...)
 
    Untuk menambah data cukup dengan code dibawah ini.
    
    ```java
    // Gunakan Map untuk datanya!!!
    Map data = new HashMap();
    data.put("id",1);
    data.put("nama","Ihsan Aryandi");
    
    this.insert("nama_tabel", data); //INSERT INTO nama_tabel(id, nama) VALUES('1', 'Ihsan Aryandi')
    ```
    
 5. Update data (UPDATE ...)
 
    Untuk merubah data cukup dengan code dibawah ini.
    
    ```java
    //Gunakan Map untuk datanya!!!
    Map data = new HashMap();
    data.put("nama","Oki Prianto")
    
    //Gunakan Map untuk wherenya!!!
    Map where = new HashMap();
    where.put("id",1);
    
    this.update("nama_tabel", data, where); //UPDATE nama_tabel SET nama='Oki Prianto' WHERE id='1'
    ```

6. Delete data (DELETE FROM ...)

   Untuk menghapus data cukup dengan code dibawah ini.
   
   ```java
   //Gunakan Map untuk wherenya!!!
   Map where = new HashMap();
   where.put("id",1);
   
   this.delete("nama_tabel", where); //DELETE FROM nama_tabel WHERE id='1'
   ```

7. Close Connection

   Untuk menutup connection database dengan code dibawah ini.
   
   ```java
   this.MySQLDisconnect();
   ```
