# Algeo-01-22004

> Tubes 1 Algeo kelompok Tubes siji algeo

dalam rangka pemenuhan tugas 1 algeo

## Susunan Program

Folder test berisikan folder input dan output. Ketika hendak menggunakan file, sertakan .txt dan langsung namanya saja (untuk read dan write)

## Cara Menjalankan

jalankan perintah ini di folder /bin

```shell
java Main
```

ketike anda menjalankannya anda akan memasuki menu utama dan ketik 0 untuk menghentikan program dan anda bisa memilih menu yang tersedia. jika terjadi kesalahan input seperti menginput angka diluar dari opsi maka program tidak akan melakukan apa apa dan anda akan kembali ke menu utama. pastikan input yang anda beri adalah berupa angka bukan character lain pada bagian pemilihan menu (PASTIKAN INPUT ANDA VALID).

# Cara pengunaan

## cara input data dalam program

> 1. (CLI)input dengan memasukkan jumlah baris dan kolom, pastikan memasukkan dalam bentuk angka bukan character lain.... kemudian masukkan matriks anda sesuai dengan ukuran yang anda pilih dalam angka float maupun integer bukan charachter lain .
> 2. (FILE TXT) input dengan memanggil nama file, dan pastikan isi file hanya berisikan matriks dengan setiap elemen berupa angka bukan huruf maupun character lainnya serta tidak ada enter maupun spasi pada setelah matriks.

## cara simpan data ke file

> masukkan nama file tujuan dengan .txtnya, jika sudah ada file yang sama maka akan di replace dan jika belum ada maka akan dibikin file baru maka hasiklnya akan terrulis di file test/output/... hal itu bisa dilakukan dengan memilih ngka 1 ketika ada pertanyaan apakah mau save dan ketik angka selain 1 (ANGKA bukan karakter lain) jika ingin skip.

pada program ini terdapat 6 menu

## 1. Sistem Persamaaan Linier

pada bagian ini terdapat 4 submenu

> 1.  metod eliminasi Gauss
>     > akan menghasilkan solusi dari spl baik dalam parametrik, tidak ditemukan, maupun dalam nilai eksak
> 2.  metode eliminasi Gauss Jordan
>     > akan menghasilkan solusi dari spl baik dalam parametrik, tidak ditemukan, maupun dalam nilai eksak
> 3.  Metode matriks balikan
>     > akan menghasilkan solusi dari spl jika nilai ada dan eksak(tidak dalam bentuk parametrik)
> 4.  Kaidah Crammer
>     > akan menghasilkan solusi dari spl jika nilai ada dan eksak(tidak dalam bentuk parametrik)

## 2. Determinan

> 1.  metode ekspansi kofaktor
>     > aakan menghasilkan nilai dari determinan tersebut pastikan input dalam bentuk matriks persegi (dan berisikan angka integer maupun float bukan char lainnya)
> 2.  metode OBE
>     > aakan menghasilkan nilai dari determinan tersebut pastikan input dalam bentuk matriks persegi (dan berisikan angka integer maupun float bukan char lainnya)

## 3. Matriks Balikan

> 1.  metod eliminasi OBE
>     > menghasilkan invers matriks, pastikan input berupa matriks persegi nXn dengan n > 0 dan jangan lupa untuk setiap input pastikan berupa float atau integer bukan character lainnya
> 2.  metode matriks adjoint
>     > menghasilkan invers matriks, pastikan input berupa matriks persegi nXn dengan n > 0 dan jangan lupa untuk setiap input pastikan berupa float atau integer bukan character lainnya

## 4. Interpolasi Polinom

> menghitung interpolasi pastikan input berbentuk matriks dan kemudian masukkan titik yang yang di taksir, jika input dalam file atasnya bentuk matriks kemudian dibawahnya ada 1 angka yang berisikan titik yang mau di taksir (sesuai spek) dan pastikan semua input dalam file ataupun cli berupa angka yang valid entak float maupun integer dan bukan merupakan charackter lainnya seperti huruf dll
>
> > Untuk input dari cli, pastikan input valid yang terdiri dari titik-titik sampel dan nilai yang ingin ditafsir.
> > Untuk input dari file, pastikan input dari file berupa titik-titik sampel dan nilai yang ingin ditafsir. Untuk titik sampel, pisahkan tiap titik dengan new line. Untuk tiap titik, pisahkan x dan y dengan spasi.

## 5. Interpolasi Bicubic Spline

> Interpolasi bicubic spline adalah teknik interpolasi yang digunakan untuk mengaproksiasi fungsi di antara titik-titik data yang diketahui. Dalam pemrosesannya, digunakan 16 buah titik, yang terdiri dari 4 titik referensi utama di bagian pusat dan 12 titik di sekitarnya. Hal ini bertujuan sebagai aproksimasi turunan dari keempat titik referensi untuk membagun permukaan bikubik.
>
> > Untuk input dari cli, pastikan input valid yang terdiri dari titik-titik sampel dan nilai yang ingin ditafsir.
> > Untuk input dari file, pastikan input dari file berupa titik-titik sampel dengan matriks ukuran 4x4 dan nilai yang ingin ditafsir di bawah mariks tersebut. Titik ini dipisahkan dengan spasi.

## 6. Regresi linier Berganda

> Menentukan hubungan antar beberapa variabel independen dengan suatu variabel dependen. Hubungan ini biasa dinyatakan dalam fungsi regresi. Fungsi ini mengambil data dari sampel yang ada untuk meningkatkan akurasi fungsi tersebut. Tujuan dari regresi linier berganda adalah memprediksi nilai variabel dependen berdasarkan nilai variabel independen yang diberikan.
>
> > Untuk input dari cli, pastikan input valid yang terdiri dari titik-titik sampel dan nilai yang ingin ditafsir.
> > Untuk input dari file, pastikan input dari file berupa titik-titik sampel dan nilai yang ingin ditafsir. Untuk titik sampel, pisahkan tiap titik dengan new line. Untuk tiap titik, pisahkan x1, x2, ... dst dan y dengan spasi.

### Eduardus Alvito Kristiadi - 13522004

### Francesco Michael Kusuma - 13522038

### Enrique Yanuar - 13522077
