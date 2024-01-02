using FINDERnew;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;


//webapplicationBuildir nesnesi uretildi alt s�n�fta
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();

//mydbcontext s�n�f�n� yap�land�rd�k
builder.Services.AddDbContext<mydbcontext>(options =>
            options.UseSqlServer(builder.Configuration.GetConnectionString("ElektronikDbConnection")));
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle

//uygulaman�n servislerinienjekte ettik(Dependency Injection)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//Burada bir web application nesnesi �retildi
var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    //bu methodlar Swagger/OpenAp� aray�z�n� kullanmak i�in bir cephe(facade) g�revi g�r�r


    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
