using FINDERnew;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;


//webapplicationBuildir nesnesi uretildi alt sýnýfta
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();

//mydbcontext sýnýfýný yapýlandýrdýk
builder.Services.AddDbContext<mydbcontext>(options =>
            options.UseSqlServer(builder.Configuration.GetConnectionString("ElektronikDbConnection")));
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle

//uygulamanýn servislerinienjekte ettik(Dependency Injection)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//Burada bir web application nesnesi üretildi
var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    //bu methodlar Swagger/OpenApý arayüzünü kullanmak için bir cephe(facade) görevi görür


    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
