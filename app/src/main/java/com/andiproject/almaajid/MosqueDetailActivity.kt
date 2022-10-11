package com.andiproject.almaajid


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MosqueDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var link: String
    private lateinit var detailShare: String
    private lateinit var judulShare: String

    companion object {
        const val EXTRA_MOSQUE = "extra_mosque"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mosque_detail)

        val mosque = intent.getParcelableExtra<Mosque>(EXTRA_MOSQUE) as Mosque


        val theDetail = mosque.detail.toString()
        judulShare = title.toString()
        detailShare = "$judulShare\n\n$theDetail\n\nLuas Tanah/Bangunan : ${mosque.luasMasjid.toString()}\nKapasitas Jemaah : ${mosque.jamaah.toString()}\nTanggal/tahun Peresmian : ${mosque.tahunBerdiri.toString()}\n\nAlamat $judulShare :\n${mosque.name.toString()}\n\nsource by Wikipedia\nFrom Al-Maajid App <3\nDownload the App Now :\nhttps://drive.google.com/drive/folders/1DGHGghlJlaXUFlX9whF8keEnnSSC3KNV?usp=sharing"

        val img: ImageView = findViewById(R.id.imageView4)
        val judul: TextView = findViewById(R.id.judul_detail)
        val deskripsi: TextView = findViewById(R.id.deskripsi_detail)
        val alamatDetail: TextView = findViewById(R.id.alamat_detail)
        val luasTanah: TextView = findViewById(R.id.tv_luasBangunan)
        val jumlahJemaah: TextView = findViewById(R.id.tv_jumlahJemaah)
        val tahunPeresmian: TextView = findViewById(R.id.tv_tahunPeresmian)

        val buttonHalamanUtama: Button = findViewById(R.id.button_to_halamanUtama)
        buttonHalamanUtama.setOnClickListener(this)

        val buttonShare: Button = findViewById(R.id.action_share)
        buttonShare.setOnClickListener(this)

        judul.text=mosque.name
        deskripsi.text=mosque.detail
        alamatDetail.text=mosque.alamat
        luasTanah.text=mosque.luasMasjid
        jumlahJemaah.text=mosque.jamaah
        tahunPeresmian.text=mosque.tahunBerdiri
        mosque.photoDetail?.let { img.setBackgroundResource(it) }

        link = mosque.linkMasjid.toString()

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button_to_halamanUtama -> {
                val url = link
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            R.id.action_share -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = detailShare
                val shareSub = judulShare
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
        }
    }
}