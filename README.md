# E-Shop🛍️
###### Akhdan Taufiq Syofyan - A - 2306152475

### Module 1 - _Coding Standards_
<details>
<summary><b>Reflection 1</b></summary>

> 1. You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

- **Menerapkan Clean Code Principles**:
  - Penamaan yang jelas → Variabel dan metode diberi nama sesuai fungsinya agar mudah dipahami.
  - Satu fungsi satu tugas → Setiap metode hanya menangani satu proses untuk menjaga keterbacaan kode.
  - DRY (Don't Repeat Yourself) → Menghindari duplikasi kode dengan membuat fungsi yang dapat digunakan kembali.
  - Konsistensi kode → Struktur kode seragam dan mengikuti standar yang diterapkan.
  - Error handling → Kesalahan yang mungkin terjadi sudah ditangani dengan baik agar tidak menyebabkan crash.


- **Menerapkan Secure Coding Practices**:
  - Validasi input → Mencegah input kosong atau tidak valid untuk menjaga integritas data.
  - Manajemen dependensi → Menggunakan pustaka resmi dan versi terbaru untuk keamanan yang lebih baik.
  - Membatasi akses API → Menggunakan HTTP method yang sesuai untuk mencegah penyalahgunaan.

</details>

<details>
<summary><b>Reflection 2</b></summary>

> 1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?

Menulis unit test membuat saya lebih percaya diri dengan kualitas kode karena setiap fungsinya telah diuji dengan baik. Jumlah unit test dalam satu kelas tergantung pada kompleksitas fitur yang diuji, tapi idealnya setiap metode utama memiliki setidaknya satu atau lebih pengujian untuk mencakup berbagai skenario. Untuk memastikan unit test sudah cukup, kita bisa melihat code coverage sebagai metrik, meskipun 100% coverage tidak selalu berarti kode bebas dari bug. Lebih dari sekadar angka, penting juga untuk menguji edge case dan skenario yang mungkin tidak terduga.

> 2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! 

Membuat functional test class baru dengan setup dan variabel yang sama bukanlah praktik clean code karena mengulang kode yang seharusnya bisa digunakan kembali. Hal Ini melanggar prinsip DRY (Don't Repeat Yourself) dan bisa membuat kode sulit dikelola. Solusinya adalah dengan membuat base test class untuk menyimpan setup umum atau gunakan utility methods agar kode tidak perlu ditulis ulang. Dengan cara ini, kode menjadi lebih rapi, efisien, dan mudah diperbarui jika ada perubahan.

</details>

---

### Module 2 - _Continuous Integration, DevOps_
<details>
<summary><b>Reflection</b></summary>

> 1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

Masalah utama yang ditemukan adalah pengujian `findById()` yang belum mencakup kasus ketika terdapat lebih dari satu loop dalam iterasi. Jika produk dengan ID tertentu tidak ditemukan pada iterasi pertama, kode masih bisa melanjutkan pencarian di elemen berikutnya. Namun, ini belum diuji secara menyeluruh, sehingga saya menambahkan test case tambahan untuk memastikan `findById()` dapat menangani skenario tersebut dengan benar.

Selain itu, terdapat penggunaan `public` yang tidak perlu pada metode dalam interface. Dalam Java, metode dalam interface secara default sudah bersifat `public`, sehingga mendeklarasikannya kembali menjadi `public` tidak diperlukan. Saya memperbaikinya dengan menghapus modifier `public` pada metode dalam interface agar lebih sesuai dengan best practice.
  
> 2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

Proses CI/CD yang saya terapkan telah memenuhi standar Continuous Integration dan Continuous Deployment karena seluruh proses berjalan secara otomatis dari pengujian hingga deployment. Setiap commit atau pull request langsung memicu unit test, analisis kode, serta alat seperti PMD, Scorecard, dan JaCoCo untuk memastikan kualitas kode tetap terjaga. Jika ada kesalahan atau pelanggaran standar, sistem memberikan umpan balik cepat, sehingga perbaikan dapat dilakukan sebelum kode dideploy. Selain itu, pipeline ini juga menangani proses build dan deployment ke Koyeb, memastikan aplikasi selalu dalam kondisi stabil tanpa perlu intervensi manual. Dengan sistem ini, pengembangan menjadi lebih efisien, minim kesalahan, serta memastikan kode yang dirilis selalu dalam kondisi optimal.
</details>

### Module 3 - _Maintainability & OO Principles_
<details>
<summary><b>Reflection</b></summary>

> 1. Explain what principles you apply to your project!

- **Single Responsibility Principle (SRP)**: Setiap kelas hanya memiliki satu tanggung jawab, seperti pemisahan `CarController` dan `ProductController`, yang mencegah satu kelas menangani terlalu banyak tugas sekaligus.
- **Open/Closed Principle (OCP)**: Kode dapat diperluas tanpa perlu dimodifikasi, seperti penambahan metode baru di `CarServiceImpl` tanpa mengubah `CarService`, menjaga stabilitas sistem.
- **Liskov Substitution Principle (LSP)**: Subkelas dapat menggantikan superclass tanpa mengubah perilaku yang diharapkan, memastikan objek dari subclass dapat digunakan di tempat objek superclass.
- **Interface Segregation Principle (ISP)**: `CarService` dan `ProductService` dibuat terpisah agar setiap service hanya memiliki metode yang benar-benar dibutuhkan tanpa harus mengimplementasikan metode yang tidak relevan.
- **Dependency Inversion Principle (DIP)**: Controller bergantung pada abstraksi (`CarService`) bukan implementasi konkret (`CarServiceImpl`), memungkinkan fleksibilitas dalam perubahan implementasi tanpa mempengaruhi bagian lain dari sistem.

> 2. Explain the advantages of applying SOLID principles to your project with examples.

- **Kode lebih mudah dipelihara**

  Dengan menerapkan SRP, setiap kelas memiliki tanggung jawab yang jelas, sehingga perubahan hanya perlu dilakukan pada bagian yang relevan tanpa memengaruhi bagian lain.

- **Lebih fleksibel untuk dikembangkan**

  Dengan menerapkan OCP, kita bisa menambahkan fitur baru, seperti metode tambahan pada `CarServiceImpl`, tanpa harus mengubah kode yang sudah ada, sehingga mengurangi risiko bug.

- **Mencegah error akibat ketidaksesuaian subclass**

  Dengan mengikuti LSP, setiap subclass bisa digunakan sebagai pengganti superclass tanpa menyebabkan error, misalnya memastikan metode pada `CarServiceImpl` tetap sesuai dengan kontrak yang diberikan oleh `CarService`.

- **Mengurangi beban implementasi yang tidak perlu** 

  Dengan menerapkan ISP, pemisahan `CarService` dan `ProductService` memastikan bahwa setiap kelas hanya mengimplementasikan metode yang memang dibutuhkan, sehingga kode lebih ringan dan tidak membebani sistem.

- **Kode lebih fleksibel dan mudah diuji**

  Dengan mengikuti DIP, controller bergantung pada abstraksi (`CarService`) dan bukan implementasi konkret (`CarServiceImpl`)`, memungkinkan kita mengganti implementasi tanpa mengubah kode di controller, serta mempermudah pengujian menggunakan mock service.

> 3. Explain the disadvantages of not applying SOLID principles to your project with examples.
     
  - **Kode menjadi sulit diperbarui**
    
    Tanpa SRP, jika `ProductController` menangani logika untuk mobil dan produk lainnya sekaligus, setiap perubahan pada salah satu fitur bisa memengaruhi seluruh controller, membuatnya sulit untuk diperbarui tanpa risiko merusak bagian lain.

  - **Risiko bug lebih tinggi**

    Jika kita tidak menerapkan OCP, menambahkan fitur baru pada `CarServiceImpl` bisa mengharuskan kita mengedit metode yang sudah ada, meningkatkan kemungkinan bug karena perubahan bisa berdampak pada fitur lain yang tidak kita sadari.
  - **Sulit untuk mengembangkan fitur baru**

    Jika tidak menerapkan DIP, dan `CarController` langsung bergantung pada `CarServiceImpl`, mengganti atau menambahkan implementasi baru (misalnya `HybridCarServiceImpl`) akan memerlukan banyak perubahan pada controller, membuat pengembangan fitur lebih sulit dan rentan error.

</details>