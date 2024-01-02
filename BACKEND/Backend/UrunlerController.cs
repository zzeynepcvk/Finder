using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FINDERnew.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class Urunler1Controller : ControllerBase
    {
        private readonly mydbcontext _dbcontext;
        public Urunler1Controller(mydbcontext dbcontext)
        {
            _dbcontext = dbcontext;
        }

        [HttpGet("Urunler")]
        public async Task<ActionResult<IEnumerable<Urun>>> Urunler([FromQuery] string urunAdi)
        {
            if (string.IsNullOrEmpty(urunAdi))
            {
                return BadRequest("UrunAdi parametresi gereklidir");
            }

            var urunler = _dbcontext.Urunler1
                .Where(u => EF.Functions.Like(u.UrunAdi, $"%{urunAdi}%"))
                .OrderBy(u => u.UrunFiyati)
                .ToList();

            if (urunler == null || !urunler.Any())
            {
                return NotFound($"'{urunAdi}' adında ürün bulunamadı");
            }

            return Ok(urunler);
        }




        [HttpGet]
        public async Task<ActionResult<IEnumerable<Urun>>> GetUrun()
        {
            if (_dbcontext.Urunler1 == null)
            {
                return NotFound();

            }
            return await _dbcontext.Urunler1.ToListAsync();

        }

        // Yeni eklenen arama endpoint'i
        // Urunler1Controller
        [HttpGet("AraUrun")]
        public async Task<ActionResult<Urun>> AraUrun([FromQuery] string urunAdi)
        {
            if (string.IsNullOrEmpty(urunAdi))
            {
                return BadRequest("UrunAdi parametresi gereklidir");
            }

            var urunRepository = new UrunRepository(_dbcontext);
            var enDusukFiyatliUrun = urunRepository.GetEnDusukFiyatliUrun(urunAdi);

            if (enDusukFiyatliUrun == null)
            {
                return NotFound($"'{urunAdi}' adında ürün bulunamadı");
            }

            return Ok(enDusukFiyatliUrun);
        }
    }
   

}

