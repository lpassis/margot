/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;
import org.alicebot.ab.*;

public class ChatBot
{
    Bot bot;
    String nome = "super";
    String caminho = System.getProperty("user.dir");
    Chat Sessao;
    
    public ChatBot()
    {
        bot = new Bot(nome, caminho);
        Sessao = new Chat(bot);
    }

    public String Conversa(String Conversa)
    {
      String Resposta;
      Resposta = Sessao.multisentenceRespond(Conversa);
      return Resposta;
    }
}
