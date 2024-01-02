using Microsoft.EntityFrameworkCore;

namespace FINDERnew
{
    public class mydbcontext : DbContext
    {

        //private 
        public mydbcontext(DbContextOptions<mydbcontext> options) : base(options)
        {
        }

        public DbSet<Urun> Urunler1 { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Özel modelleme kodları buraya eklenebilir.
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                // IConfiguration kullanarak appsettings.json dosyasındaki bağlantı dizesini alın
                IConfigurationRoot configuration = new ConfigurationBuilder()
                    .SetBasePath(AppDomain.CurrentDomain.BaseDirectory)
                    .AddJsonFile("appsettings.json")
                    .Build();

                // Bağlantı dizesini alın
                string connectionString = configuration.GetConnectionString("ElektronikDbConnection");

                // SQL Server bağlantı dizesini kullanarak DbContext'i yapılandırın
                optionsBuilder.UseSqlServer(connectionString);
            }
        }
    }

    public class Urun
    {
        public int ID { get; set; }
        public string UrunAdi { get; set; }
        public decimal UrunFiyati { get; set; }

        public string SiteAdi { get; set; }

        public string UrunUrl { get; set; }

        //public string ResimUrl { get; set; }



    }

    public class UrunRepository
    {
        private readonly mydbcontext _dbContext;


        //mydbcontext sınıfı,urunler1 controller sınıfına constructor metot aracılığıyla enjekte edilmiştir.
        //Boylece sınıflar arasındaki bağlantı ve bağımlılık azalır ve test edilebilirlik artar
        public UrunRepository(mydbcontext dbContext)
        {
            _dbContext = dbContext ?? throw new ArgumentNullException(nameof(dbContext));
        }

        public Urun GetEnDusukFiyatliUrun(string urunAdi)
        {
            var urun = _dbContext.Urunler1
            
        .AsEnumerable()  // Bu, sorgunun geri kalanını uygulama tarafında değerlendirecektir.
        .Where(u => u.UrunAdi.Contains(urunAdi, StringComparison.OrdinalIgnoreCase))
        .OrderBy(u => u.UrunFiyati)
         .FirstOrDefault();


            return urun;
        }

        public IEnumerable<Urun> TumUrunleriGetir()
        {
            return _dbContext.Urunler1.ToList();
        }

        public void UrunEkle(Urun urun)
        {
            _dbContext.Urunler1.Add(urun);
            _dbContext.SaveChanges();
        }

        // Diğer CRUD (Create, Read, Update, Delete) işlemleri buraya eklenir.
    }
}

