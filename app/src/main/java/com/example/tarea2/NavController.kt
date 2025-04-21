package com.example.tarea2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tarea2.ui.Categoria
import com.example.tarea2.ui.Contenido
import com.example.tarea2.ui.FormularioScreen
import com.example.tarea2.ui.HomeScreen
import com.example.tarea2.ui.SecondScreen
import kotlinx.serialization.Serializable
import androidx.compose.material3.Text
import com.example.tarea2.ui.FormularioContentScreen
import com.example.tarea2.ui.DetalleContenidoScreen

@Serializable
object Home

@Serializable
data class SecondPage(val id: Int)

@Serializable
data class FormularioCat(val size: Int)

@Serializable
data class FormularioCont(val categoriaId: Int, val contenidoSize: Int)

@Serializable
data class DetalleContenidoPage(val idCategoria: Int, val idContenido: Int)



@Composable
fun Navigation(){
    val navController = rememberNavController()
    val categoria = remember{ mutableStateListOf<Categoria>().apply{
        add(
            Categoria(
                id=0,
                title = "Accion",
                icon = R.drawable.accion,
                contenido = mutableListOf(
                    Contenido(0,"Naruto",R.drawable.naruto,
                        "Naruto, un aprendiz de ninja de la Aldea Oculta de " +
                                "Konoha es un chico travieso que desea llegar a ser el " +
                                "Hokage de la aldea para demostrar a todos lo que vale. " +
                                "Lo que descubre al inicio de la historia es que la gente " +
                                "le mira con desconfianza porque en su interior está " +
                                "encerrado el demonio Kyubi que una vez destruyó la aldea, " +
                                "y que el anterior líder de la misma tuvo que encerrar en su " +
                                "cuerpo siendo aún muy pequeño, a coste de su vida. Aunque sus " +
                                "compañeros no saben esto, tampoco le aprecian porque es mal " +
                                "estudiante y siempre está haciendo bromas. " +
                                "Sin embargo, la forma de actuar y la determinación de Naruto " +
                                "demuestran a los demás que puede llegar muy lejos, y el " +
                                "recelo de los otros chicos se va disipando. Naruto y sus " +
                                "compañeros Sakura y Sasuke, junto a su maestro Kakashi " +
                                "tendrán que enfrentarse a una serie de combates y misiones a " +
                                "lo largo de la historia que les permitirán mejorar y crecer. " +
                                "Naruto se vera enfrentado a sus principales enemigos " +
                                "Akatsuki, Itachi y Kisame."),
                    Contenido(1,"Bleach",R.drawable.bleach,
                        "Kurosaki Ichigo es un estudiante de instituto de 15 años, " +
                                "que tiene una peculiaridad: es capaz de ver, oír y hablar " +
                                "con fantasmas. Pero no sabe hasta dónde puede abarcar la " +
                                "clasificación de espíritus, ni lo que conlleva el saberlo. " +
                                "Un buen día, una extraña chica de pequeña estatura que " +
                                "viste ropas negras de samurai entra en su cuarto. " +
                                "Se llama Rukia Kuchiki, y es una Shinigami (Dios de la Muerte). " +
                                "Ante la incredulidad de Ichigo, le explica que su trabajo es " +
                                "mandar a las almas buenas o plus a un lugar llamado la Sociedad " +
                                "de Almas, y eliminar a las almas malignas o hollows. " +
                                "Luego junto a Inoue Orihime, Ishida Ury y Sado Yasutora se " +
                                "veran envueltos en diferentes batallas, las cuales iran " +
                                "desarrollando sus diferentes habilidades que le otorgaran a " +
                                "cada uno su importancia en la serie.")
                )
            )
        )
        add(
            Categoria(
                id =1,
                title = "Romance",
                icon = R.drawable.romance,
                contenido = mutableListOf(
                    Contenido(0,"Danjo no Yuujou wa Seiritsu suru?",R.drawable.danjo_no_yuujou_wa_seiritsu_suru,
                        description ="La amistad de la infancia entre Himari y " +
                                "Yu se tambalea cuando Yu se reencuentra en preparatoria " +
                                "con su primer amor. Himari, que nunca experimentó la emoción " +
                                "del amor, ahora debe enfrentar sus propios sentimientos. " +
                                "Sus sueños compartidos y los tranquilos días en su club de " +
                                "jardinería se ponen a prueba en esta historia con amor, " +
                                "flores y los altibajos que supone madurar." ),
                    Contenido(1, title = "Class no Daikirai na Joshi to Kekkon suru Koto ni Natta",
                        R.drawable.class_no_daikirai_na_joshi_to_kekkon_suru,
                        description = "El estudiante de preparatoria Hojo Saito " +
                                "está a punto de heredar la gran empresa de su abuelo. Para ello " +
                                "debe casarse con Akane Sakuramori, la chica a la que más detesta y " +
                                "que a su vez le detesta a él. Los dos están decididos a " +
                                "ocultar su imprevisto matrimonio a sus compañeros, " +
                                "pero al comenzar su nueva vida como pareja, la distancia que los " +
                                "separa comienza a reducirse." )

                )
            )
        )
        add(
            Categoria(
                id =2,
                title = "Fantasia",
                icon = R.drawable.fantasia,
                contenido = mutableListOf(
                    Contenido(0,"Girumasu",R.drawable.girumasu,
                        description ="Alina pensaba que había encontrado el trabajo perfecto como " +
                                "recepcionista del gremio. Un trabajo estable, tranquilo y con un " +
                                "uniforme monísimo. Pero este trabajo de ensueño se convierte en " +
                                "una pesadilla cada vez que los aventureros se quedan atrapados " +
                                "en el proceso de completar una mazmorra. Cansada de trabajar " +
                                "hasta las tantas por las noches, Alina decide acabar con los jefes " +
                                "ella misma. Sus impresionantes habilidades le han hecho ganarse el " +
                                "apodo de Verdugo. ¿Podrá mantener su identidad en secreto?" ),
                    Contenido(1,"Farmagia",R.drawable.farmagia,
                        "En Felicidad, unos granjeros conocidos como los Farmagia crían" +
                                " monstruos bajo el pacífico gobierno del Magus Diluculum. " +
                                "Tras la muerte del Magus, estalla una lucha de poder entre " +
                                "fuerzas que utilizan monstruos para hacerse con el control. " +
                                "En la ciudad de Centvelt, el Farmagia Ten y sus amigos se " +
                                "unen para enfrentarse al nuevo y déspota gobernante, Glaza. " +
                                "Ten, sus amigos y los monstruos que han criado deberán " +
                                "mantenerse firmes para defender su libertad.")
                )
            )
        )
    }}

    val agregarCategoria:(Categoria)-> Unit ={ nuevaCategoria -> categoria.add(nuevaCategoria)}
    val agregarContenido:(Int,Contenido)->Unit={categoriaId,nuevoContenido ->
        categoria.find{it.id == categoriaId}?.contenido?.add(nuevoContenido)
    }

    //------------------------------------------------------------------------------------------

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(categoria = categoria,
                onNavigateToFormulario = {navController.navigate(
                                          FormularioCat(size = categoria.size))},
                navController = navController)
        }

        composable<SecondPage>{ backStackEntry ->
            val args = backStackEntry.toRoute<SecondPage>()
            val selectedCategoria = categoria.find{it.id == args.id}
            if(selectedCategoria !=null){
                SecondScreen(navController,selectedCategoria)
            }
            else{
                Text("Categoría no encontrada")
            }
        }

        composable <FormularioCat>{
            FormularioScreen(onAgregar = agregarCategoria,
                onBack = {navController.popBackStack()},
                categoria.size)
        }

        composable<FormularioCont> { backStackEntry ->
            val args = backStackEntry.toRoute<FormularioCont>()
            FormularioContentScreen(
                onAgregar = { nuevoContenido ->
                    agregarContenido(args.categoriaId, nuevoContenido)
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() },
                contenidoSize = args.contenidoSize
            )
        }

        composable<DetalleContenidoPage> { backStackEntry ->
            val args = backStackEntry.toRoute<DetalleContenidoPage>()
            val categoriaSeleccionada = categoria.find { it.id == args.idCategoria }
            val contenidoSeleccionado = categoriaSeleccionada?.contenido?.find { it.id == args.idContenido }

            if (contenidoSeleccionado != null) {
                DetalleContenidoScreen(contenido = contenidoSeleccionado,navController)
            } else {
                Text("Contenido no encontrado")
            }
        }


    }
}