<?php
  function checkEmail(){
		$newEmails = null;

		$hostname = '{imap.gmail.com:993/imap/ssl}INBOX';
		$username = 'cobaphp111@gmail.com';
		$password = '123Ganteng.';

		$inbox = imap_open($hostname,$username,$password) or die('Cannot connect to Gmail: ' . imap_last_error());
		
		$emails = imap_search($inbox,'UNSEEN');

		if($emails) {
			$i = 0;
			foreach($emails as $emailNumber) {
				$invalid = false;
				$header = imap_headerinfo($inbox,$emailNumber);
				$from = isset($header->from) ? $header->from : null;
				if($from != null){
					$fromaddress = null;
					foreach($from as $id => $object){
						$fromaddress = isset($object->mailbox) && isset($object->host) ? $object->mailbox . "@" . $object->host : null;
					}
					$bodymsg = '';
					$attachmentExist = 'N';
					$structure = imap_fetchstructure($inbox, $emailNumber);
					if(isset($structure->parts) && is_array($structure->parts)) {
						if(isset($structure->parts[1])){
							$parts1 = $structure->parts[1];
							if(isset($parts1->disposition) && $parts1->disposition == "ATTACHMENT"){
								$attachmentExist = 'Y';
								$parts0 = $structure->parts[0];
								if(isset($parts0->parts[1])){
									$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '1.2'));
								}
								else if(isset($parts0->parts[0])){
									$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '1.1'));
								}
								else{
									$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '1'));
								}
							}
							else{
								$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '2'));
							}
						}
						else{
							$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '1'));
						}
					}
					else{
						$bodymsg = imap_qprint(imap_fetchbody($inbox, $emailNumber, '1'));
					}

					if($fromaddress != null){
						$newEmails[$i]['emailFrom'] = $fromaddress;
						$newEmails[$i]['from'] = isset($header->fromaddress) ? $header->fromaddress : $fromaddress;
						if(isset($header->udate)){
							$newEmails[$i]['date'] = date("Y-m-d H:i:s", $header->udate);
						}
						else{
							$invalid = true;
						}
						
						if(isset($header->subject)){
							$newEmails[$i]['subject'] = $header->subject;
						}
						else{
							$invalid = true;
						}

						$newEmails[$i]['body'] = $bodymsg;
						$newEmails[$i]['attachmentExist'] = $attachmentExist;
					}
				}
				if($invalid){
					unset($newEmails[$i]);
				}
				else{
					$i++;
				}
			}
		}
		
		$errors = imap_errors();

		imap_close($inbox);
		
		var_dump($newEmails);
	}

  checkEmail();
?>