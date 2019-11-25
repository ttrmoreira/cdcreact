describe("Algarismo Romano", function(){


    it("Algarismos romanos convertidos para números decimais", function(){

        var algarismoRomano = new AlgarismoRomano();
        expect(algarismoRomano.fromRoman("CMXCIX")).toEqual(999);
    });

});