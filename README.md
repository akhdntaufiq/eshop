# E-Shop🛍️
###### Akhdan Taufiq Syofyan - A - 2306152475

### Reflection 1📝
> You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

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

### Reflection 2📝
> After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?

Menulis unit test membuat saya lebih percaya diri dengan kualitas kode karena setiap fungsinya telah diuji dengan baik. Jumlah unit test dalam satu kelas tergantung pada kompleksitas fitur yang diuji, tapi idealnya setiap metode utama memiliki setidaknya satu atau lebih pengujian untuk mencakup berbagai skenario. Untuk memastikan unit test sudah cukup, kita bisa melihat code coverage sebagai metrik, meskipun 100% coverage tidak selalu berarti kode bebas dari bug. Lebih dari sekadar angka, penting juga untuk menguji edge case dan skenario yang mungkin tidak terduga.

> Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! 

Membuat functional test class baru dengan setup dan variabel yang sama bukanlah praktik clean code karena mengulang kode yang seharusnya bisa digunakan kembali. Hal Ini melanggar prinsip DRY (Don't Repeat Yourself) dan bisa membuat kode sulit dikelola. Solusinya adalah dengan membuat base test class untuk menyimpan setup umum atau gunakan utility methods agar kode tidak perlu ditulis ulang. Dengan cara ini, kode menjadi lebih rapi, efisien, dan mudah diperbarui jika ada perubahan.