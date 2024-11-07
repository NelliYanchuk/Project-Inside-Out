package out.factoriaf5.out_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

public class AppDiaryTest {

        @InjectMocks
        private AppDiary appDiary; // Objeto de prueba
    
        @Mock
        private PremiumManager premiumManager;
    
        @Mock
        private Diary diary;
    
        @Mock
        private Menu menu;
    
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            System.setOut(new PrintStream(outputStreamCaptor)); // Captura la salida de la consola
        }
    
        @Test
        void testAddMomentOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class);
                MockedStatic<Diary> diaryMock = Mockito.mockStatic(Diary.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(1); // Simula la opción "1" para agregar un momento

                appDiary.start();

                diaryMock.verify(() -> Diary.addMoment(anyList(), any(Scanner.class)), times(1)); // Verifica que se llamó a agregar momento
            }
        }

        @Test
        void testShowAllMomentsOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class);
                MockedStatic<Diary> diaryMock = Mockito.mockStatic(Diary.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(2); // Simula la opción "2" para mostrar todos los momentos

                appDiary.start();

                diaryMock.verify(() -> Diary.showAllMoments(anyList()), times(1)); // Verifica que se llamó a mostrar todos los momentos
            }
        }

        @Test
        void tesdeleteMomentOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic (Menu.class);
                 MockedStatic<Diary> diaryMock = Mockito.mockStatic (Diary.class)) {
                
                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(3); // Simula la opción "2" para mostrar todos los momentos

                appDiary.start();

                diaryMock.verify(() -> Diary.deleteMoment(anyList(), any(Scanner.class)), times(1)); // Verifica que se llamó a eliminar// momento
            }
        }

        @Test
        void testFilterByEmotionOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class);
                MockedStatic<Diary> diaryMock = Mockito.mockStatic(Diary.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(4); // Opción 4: Filtrar
                menuMock.when(Menu::getFilterOption).thenReturn(1); // Filtrar por emoción

                appDiary.start();

                diaryMock.verify(() -> Diary.filterByEmotion(anyList(), any(Scanner.class)), times(1)); // Verifica el filtro por emoción
            }
        }

        @Test
        void testFilterByDateOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class);
                MockedStatic<Diary> diaryMock = Mockito.mockStatic(Diary.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(4); // Opción 4: Filtrar
                menuMock.when(Menu::getFilterOption).thenReturn(2); // Filtrar por fecha

                appDiary.start();

                diaryMock.verify(() -> Diary.filterByDate(anyList(), any(Scanner.class)), times(1)); // Verifica el filtro por fecha
            }
        }

        @Test
        void testActivatePremiumOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class);
                MockedStatic<PremiumManager> premiumMock = Mockito.mockStatic(PremiumManager.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(5); // Opción 5: Activar Premium

                appDiary.start();

                premiumMock.verify(PremiumManager::activatePremium, times(1)); // Verifica la activación de Premium
            }
        }

        @Test
        void testExitProgramOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(6); // Opción 6: Salir

                appDiary.start();

                menuMock.verify(Menu::exitProgram, times(1)); // Verifica que se llamó al método de salir del programa
            }
        }

        @Test
        void testDefaultCaseOption() {
            try (MockedStatic<Menu> menuMock = Mockito.mockStatic(Menu.class)) {

                menuMock.when(Menu::isRunning).thenReturn(true, false); // Ejecuta el bucle una vez y luego sale
                menuMock.when(Menu::getUserOption).thenReturn(99); // Opción no válida para activar el caso predeterminado

                appDiary.start();

                menuMock.verify(Menu::showMenu, atLeastOnce()); // Verifica que se muestra el menú en el caso predeterminado
            }
        }
}
    