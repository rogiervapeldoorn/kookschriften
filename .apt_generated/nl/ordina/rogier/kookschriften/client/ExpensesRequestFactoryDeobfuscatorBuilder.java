// Automatically Generated -- DO NOT EDIT
// nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory
package nl.ordina.rogier.kookschriften.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class ExpensesRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("FKuor4aGiX_TWyh9xjSupFDetdo="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("getUploadUrl")
  .withRequestContext("nl.ordina.rogier.kookschriften.client.UploadUrlRequest")
  .build());
withOperation(new OperationKey("kkGPpP7fikOhirkKVIRBGNIvZ8o="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;)Lnl/ordina/rogier/kookschriften/domain/UploadedImage;")
  .withMethodName("findUploadedImageWithKey")
  .withRequestContext("nl.ordina.rogier.kookschriften.client.UploadedImageRequest")
  .build());
withOperation(new OperationKey("BBKxq2_AcI9wYCqbTV2K3vQEkCg="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findMyRecepten")
  .withRequestContext("nl.ordina.rogier.kookschriften.client.ReceptRequest")
  .build());
withOperation(new OperationKey("0bJaS9sY2ZBCnFiONcQ5VfOEDcg="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lnl/ordina/rogier/kookschriften/shared/proxy/ReceptProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lnl/ordina/rogier/kookschriften/domain/Recept;)Ljava/lang/Void;")
  .withMethodName("save")
  .withRequestContext("nl.ordina.rogier.kookschriften.client.ReceptRequest")
  .build());
withOperation(new OperationKey("BWvoAzF5L6B7rvY1jcCpWCx8O34="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllRecepten")
  .withRequestContext("nl.ordina.rogier.kookschriften.client.ReceptRequest")
  .build());
withRawTypeToken("w1Qg$YHpDaNcHrR5HZ$23y518nA=", "com.google.web.bindery.requestfactory.shared.EntityProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("x$vWGabv_V$mR4E7Z9Wj0lEqYbY=", "nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy");
withRawTypeToken("eCIByiRk93NmOYT$SBZk$b1aZaA=", "nl.ordina.rogier.kookschriften.shared.proxy.TagProxy");
withRawTypeToken("hYaPLql4_oEU04Jtcp24QYjTuKA=", "nl.ordina.rogier.kookschriften.shared.proxy.UploadedImageProxy");
withClientToDomainMappings("nl.ordina.rogier.kookschriften.domain.Recept", Arrays.asList("nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy"));
withClientToDomainMappings("nl.ordina.rogier.kookschriften.domain.Tag", Arrays.asList("nl.ordina.rogier.kookschriften.shared.proxy.TagProxy"));
withClientToDomainMappings("nl.ordina.rogier.kookschriften.domain.UploadedImage", Arrays.asList("nl.ordina.rogier.kookschriften.shared.proxy.UploadedImageProxy"));
}}
