const turmaController = new TurmaController();

document.querySelector('.form')
        .addEventListener('submit', turmaController.adiciona.bind(turmaController));
